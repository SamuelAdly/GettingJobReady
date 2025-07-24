import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class timeBasedTwo {
    public Map<String, ArrayList<timeStampValuePair>> map;

    public timeBasedTwo() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key) == false) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new timeStampValuePair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key) == false) {
            return "";
        }
        ArrayList<timeStampValuePair> keyList = map.get(key);
        int left = 0;
        int right = keyList.size() - 1;
        String result = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            timeStampValuePair cur = keyList.get(mid);
            if (cur.timestamp == timestamp) {
                return cur.value;
            } else if (cur.timestamp < timestamp) {
                left = mid + 1;
                result = cur.value;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        timeBasedTwo store = new timeBasedTwo();
        store.set("foo", "bar", 1);
        System.out.println(store.get("foo", 1)); // Output: bar
        System.out.println(store.get("foo", 2)); // Output: bar
        store.set("foo", "baz", 3);
        System.out.println(store.get("foo", 3)); // Output: baz
        System.out.println(store.get("foo", 4)); // Output: baz
        System.out.println(store.get("foo", 2)); // Output: bar
    }
}

class timeStampValuePair {
    public int timestamp;
    public String value;

    public timeStampValuePair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}