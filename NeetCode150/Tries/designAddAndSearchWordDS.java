import java.util.HashMap;

class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;

}

public class designAddAndSearchWordDS {


    public designAddAndSearchWordDS() {

    }

    public void addWord(String word) {

    }

    public boolean search(String word) {

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
