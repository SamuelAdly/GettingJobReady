import java.util.ArrayList;
import java.util.List;

/*
 * Word Search II is a hard Trie problem on leetcode
 * the problem asks you to find all words in a given list that can be formed in a 2D board of characters
 * the words can be formed by connecting adjacent characters in the board horizontally or vertically
 * the words can only be formed if all characters in the word exist in the board and you cant use the same character cell more than once in a word
 * this approach used a trie to store the words and then we dfs the board to find the words that can be formed that way we search all words at once and not one by one
 * time complexity is O(m * n * 4 * 3^(l-1) + s) where m is the number of rows in the board, n is the number of columns in the board, l is the maximum length of a word, and s is the total number of letters in all words
 * space complexity is O(s) where s is the total number of letters in all words
 */


/*
 * The trienode class is what creates the trie
 * each node consists of an array of size 26 (for all lowercase letters) and two integers idx and refs
 * index represents the index of the word in the words array if this node is the end of a word otherwise it is -1 
 * this means that if it is a word it will store the index of that word in the words array if it is not a word it will store -1
 * refs represents the number of words that pass through this node (number of references to this node)
 * this is used to help with pruning the trie when a word is found
 * 
 * addword is what creates the trie
 * we are given the word and the index of that word from the wordsearch2 findwords method
 * we start off by setting the current node to the root and incrementing the refs of the root
 * then we simply turn the string word into a char array that we can iterate through to create the trie
 * if that character exists in that children array of the node then we continue down the path if not wew create a new trienode at that index and continue down the path
 * once we reach the end of the word we set the idx of that node to the index of the word in the words array
 * we also increment the refs of each node we pass through
 */
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int idx = -1;
    int refs = 0;

    public void addWord(String word, int i) {
        TrieNode cur = this;
        cur.refs++;
        for (char c: word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
            cur.refs++;
        }
        cur.idx = i;
    }
}

/*
 * the wordsearch2 class is where we start the dfs
 * we start off by creating a list of strings to store the results we found in the dfs
 * the findwords method is the method that was given to us in the problem
 * we start off by creating a root trienode and adding all the words to the trie using the addword method which was explained above
 * then we iterate through the board and for each cell we call the dfs method which is what will find the words on the board
 * since it is a 2d board we need the nested for loops to iterate through the board
 * 
 * the dfs method is where we find the words on the board
 * we are given the board, the current node in the trie, the current row and column in the board, and the words array
 * first we check our base cases which are simply if we are out of bounds of the board or if the current cell is already visited using our marker or if the current character does not exist in the children array of the current node
 * if we pass these base cases we go on
 * first we create a temp variable to store the current character in the board and replace the board cell with the marker '*' to represent that it is visited
 * then we set prev trienode to the current node so we can use it later if we need to prune the trie
 * then we set the current node to the child node that represents the current character in the board using char arithmetic
 * then we check if the current node is the end of a word by checking if the idx is not -1
 * if it is the end of a word we add that word to the result list using the index stored in the idx variable
 * then we set the idx to -1 so we dont add the same word again and decrement the refs variable since we found a word that passes through this node
 * if the refs variable is 0 then we know that no other words pass through this node so we can prune the trie by setting the current node to null and setting the child node of the previous node to null
 * then we restore the board cell to the original character using the temp variable and return since we pruned the trie
 * if we did not prune the trie we continue the dfs in all four directions (up, down, left, right)
 * after we finish the dfs we restore the board cell to the original character using the temp variable
 */

public class wordSearch2 {
    List<String> res = new ArrayList<>();
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            root.addWord(words[i], i);
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, root, r, c, words);
            }
        }
        return res;
    }

    private void dfs(char[][] board, TrieNode node, int r, int c, String[] words) {
        if (r < 0 || c < 0 || r >=board.length || c >= board[0].length || board[r][c] == '*' || node.children[board[r][c] - 'a'] == null) return;
    
    char temp = board[r][c];
    board[r][c] = '*';
    TrieNode prev = node;
    node = node.children[temp - 'a'];

    if (node.idx != -1) {
        res.add(words[node.idx]);
        node.idx = -1;
        node.refs--;
        if (node.refs == 0) {
            node = null;
            prev.children[temp - 'a'] = null;
            board[r][c] = temp;
            return;
        }
    }
    dfs(board, node, r + 1, c, words);
    dfs(board, node, r - 1, c, words);
    dfs(board, node, r, c + 1, words);
    dfs(board, node, r, c - 1, words);
    board[r][c] = temp;
}

    public static void main(String[] args) {
        wordSearch2 ws = new wordSearch2();
        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(ws.findWords(board, words));
    }
}
