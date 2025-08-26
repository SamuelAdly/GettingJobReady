import java.util.HashMap;

public class cacheLRU1 {

    /*
     * LRU Cache is a leetcode medium linked list problem
     * we want to simulate a least recently used cache system in which we have a get and put method
     * the get method simply retrieves the value associated with a key from the cache 
     * the put method adds a key value pair into the cache if it does not exist already and manages the deletion or update of keys in the cache
     * 
     * For this implementation, seeing the need for key value pairs its obvious that we can use a hashmap to store the key values
     * then the class is first created we have the constructor set the capacity and create the hashmap
     * the get method simply returns map.getordefault(key, -1) which means that we either return the value if that key exists or default to -1 and return that 
     * the put method checks to see if the cache is full meaning we must remove the LRU entry
     * if that is true we set lruKey to -1 which is the initial value indicating no key has been found yet
     * then we loop through the keys to find the key with the smallest value which is the least recently used key
     * once we find that key we remove it from the map and put the new key value pair
     */

    private final HashMap<Integer, Integer> map;
    private final int capacity;
    
    public cacheLRU1(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (map.size() >= capacity) {
            int lruKey = -1;
            for (int k : map.keySet()) {
                if (lruKey == -1 || map.get(k) < map.get(lruKey)) {
                    lruKey = k;
                }
            }
            map.remove(lruKey);
        }
        map.put(key, value);
    }



    public static void main(String[] args) {
        cacheLRU1 cache = new cacheLRU1(2);
        cache.put(1, 10);
        System.out.println(cache.get(1));
        cache.put(2, 20);
        cache.put(3, 30);
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));

    }
}
