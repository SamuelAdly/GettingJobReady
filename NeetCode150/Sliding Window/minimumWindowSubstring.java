import java.util.HashMap;
import java.util.Map;

public class minimumWindowSubstring {
    
    public String minWindow (String s, String t) {
        if (t.length() > s.length()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int charHave = 0, charNeed = tMap.size(), left = 0;
        int minLength = Integer.MAX_VALUE;
        int [] res = {-1, -1};

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (tMap.containsKey(c) && windowMap.get(c).equals(tMap.get(c))) {
                charHave++;
            }

            while (charHave == charNeed) {
                if ((right - left + 1) < minLength) {
                    minLength = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (tMap.containsKey(leftChar) && windowMap.get(leftChar) < tMap.get(leftChar)) {
                    charHave--;
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);

    }

    public static void main(String[] args) {
        minimumWindowSubstring sol = new minimumWindowSubstring();
        System.out.println("Test of minimum window substring:");
        System.out.println("s = ADOBECODEBANC, t = ABC");
        System.out.println("Expected: BANC");
        System.out.println("Output: " + sol.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("s = a, t = a");
        System.out.println("Expected: a");
        System.out.println("Output: " + sol.minWindow("a", "a"));
        System.out.println("s = a, t = aa");
        System.out.println("Expected: ");
        System.out.println("Output: " + sol.minWindow("a", "aa"));
    }
}
