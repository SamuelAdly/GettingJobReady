/*
 * implement trie prefix tree is a medium trie problem on leetcode
 * a trie is a tree data structure that is used to store a dynamic set or associative array where the keys are usually strings
 * unlike a binary search tree, no node in the tree stores the key associated with that node
 * for this code we are asked to create the methods for insert, search, and startsWith
 * I created the TrieNode class to represent each node in the trie
 * each node has a hashmap of children and a boolean to represent if it is the end of a word
 * the main class implementTriePrefixTree has a root node that is initialized in the constructor
 * the insert method takes in a word and inserts it into the trie by adding each character to the trie as a node
 * the search method takes in a word and searches the trie for that word by traversing the trie using the characters in the word
 * the startsWith method takes in a prefix and searches the trie for that prefix by traversing
 * the trie using the characters in the prefix
 * all methods run in O(n) time where n is the length of the word or prefix being inserted or searched
 * and O(t) space for the total number of trieNodes in the trie
 */

import java.util.HashMap;

class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;

}

public class implementTriePrefixTree {
    private TrieNode root;


    public implementTriePrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < wordArr.length; i++) {
            cur.children.putIfAbsent(wordArr[i], new TrieNode());
            cur = cur.children.get(wordArr[i]);
        }
        cur.endOfWord = true;

    }

    public boolean search(String word) {
        TrieNode cur = root;
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < wordArr.length; i++) {
            if (cur.children.containsKey(wordArr[i]) == false) return false;
            cur = cur.children.get(wordArr[i]);
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        char[] prefixArr = prefix.toCharArray();
        for (int i = 0; i < prefixArr.length; i++) {
            if (!cur.children.containsKey(prefixArr[i])) return false;
            cur = cur.children.get(prefixArr[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        implementTriePrefixTree trie = new implementTriePrefixTree();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app")); 
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
    
}
