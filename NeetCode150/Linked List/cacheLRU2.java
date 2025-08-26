import java.util.HashMap;

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
public class cacheLRU2 {

    /*
     * LRU Cache is a leetcode medium linked list problem
     * we want to simulate a least recently used cache system in which we have a get and put method
     * the get method simply retrieves the value associated with a key from the cache 
     * the put method adds a key value pair into the cache if it does not exist already and manages the deletion or update of keys in the cache
     */

    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;


    public cacheLRU2(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = right;
        this.right.prev = left;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        } 
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > capacity) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }



    public static void main(String[] args) {
        cacheLRU2 cache = new cacheLRU2(2);
        cache.put(1, 10);
        System.out.println(cache.get(1));
        cache.put(2, 20);
        cache.put(3, 30);
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));

    }
}
