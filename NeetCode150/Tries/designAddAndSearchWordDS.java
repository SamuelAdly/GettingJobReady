
/*
 * Design Add and Search Word Data Structure is a medium Trie problem on leetcode
 * the problem asks you to design a data structure that supports adding new words and finding existing words with a twist
 * some searches have a '.' character which can represent any letter
 * this makes it so that the . can be any of the 26 letters in the alphabet so you must do a dfs for each possibility causing recursion to be used
 * 
 * We start off by defining our trienode class which has an array of size 26 to represent each letter in the alphabet and a boolean to represent if it is the end of a word
 * the main class designAddAndSearchWordDS has a root node that is initialized in the constructor
 * each time a trienode is created it creates a new array of size 26 if needed
 * 
 * the addword method takes in the string word that the user provides
 * it then iterates through the string as a char array and for each character it checks if the corresponding index in the children array is null
 * if it is null it creates a new trienode at that index and sets it to the current trienode
 * then it sets the current trienode to the new trienode 
 * this forms a sort of tree/path for each word added
 * once the loop is done it sets the endofword boolean to true to represent that this is the end of a valid word
 * 
 * the search method calls on a helper dfs method
 * it passes the word, the current index in the word, and the root node
 * the dfs method iterates through the word as a char array and for each character it checks if it is a '.'
 * if it is a '.' it iterates through the children array and calls the dfs method recursively for each children node
 * if it is not a '.' it checks if the corresponding index in the children array is null
 * if it is null it returns false
 * if it is not null it sets the current trienode to the children node and continues until the end of word or a false is returned
 * once the loop is done it returns the endofword boolean to represent if this is the end of a valid word
 * 
 * all methods run in O(n) time and O(t + n) space 
 */
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;

}

public class designAddAndSearchWordDS {
    private TrieNode root;


    public designAddAndSearchWordDS() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c: word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode root) {
        TrieNode cur = root;
        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : cur.children) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (cur.children[c - 'a'] == null) return false;
                cur = cur.children[c - 'a'];
            }
        }
        return cur.endOfWord;
    }

    public static void main (String[] args) {
        designAddAndSearchWordDS wordDictionary = new designAddAndSearchWordDS();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad")); 
        System.out.println(wordDictionary.search(".ad")); 
        System.out.println(wordDictionary.search("b..")); 
    }
    
}
