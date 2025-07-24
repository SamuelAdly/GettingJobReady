import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* This leetcode problem involves picking the correct data structure to store keys, values, and timestamps and then completing get and set while also incorporating binary search from the treemap
 * We will use a hashmap that stores the string of key as its key and a treemap to store the values and timestamps for each key. In the treemap, the key will be the timestamp and the value will be the string.
 * below I initialized the map in the constructor.
 */
public class timeBasedKeyValueStore {
    public Map<String, TreeMap<Integer, String>> map;

    public timeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    // The set method puts the value into the map. We first check if the key already exists in the outer map. 
    // If its not there we add the key and a new treemap. If it is then we just put the timestamp and value into the treemap.
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key) == false) {
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }

    //The get method returns the correct value for the key and timestamp given (if the exact timestamp isnt there we pick the closest smallest)
    // We first check if the key exists in the outer map. If it does not we return an empty string.
    // If it does we extract the treemap from that key
    // Then we use the floorEntry method to get the closest timestamp that is less than or equal to the given timestamp.
    // If there is no such timestamp, we return an empty string.
    // Otherwise, we return the value associated with that timestamp.
    public String get(String key, int timestamp) {
        if (map.containsKey(key) == false) {
            return "";
        }
        TreeMap<Integer, String> timeMap = map.get(key); 
        Map.Entry<Integer, String> entry = timeMap.floorEntry(timestamp);
        if (entry == null) {
            return "";
        } else {
            return entry.getValue();
        }
    }



    public static void main(String[] args) {
        timeBasedKeyValueStore store = new timeBasedKeyValueStore();
        store.set("foo", "bar", 1);
        System.out.println(store.get("foo", 1)); // Output: bar
        System.out.println(store.get("foo", 2)); // Output: bar
        store.set("foo", "baz", 3);
        System.out.println(store.get("foo", 3)); // Output: baz
        System.out.println(store.get("foo", 4)); // Output: baz
        System.out.println(store.get("foo", 2)); // Output: bar
    }
    
}
