import java.util.HashMap;
import java.util.Map;

public class minimumWindowSubstring {

    /*
     * Minimum Window Substring is a leetcode Hard problem involving the sliding window technique
     * The problem gives you two strings, S and T, and asks you to find the shortest substring of S that contains all the characters of T
     * The best approach for this is an O(n) time complexity and O(m) space complexity
     * The solution first checks if t is longer than s because that would mean that T cannot be a substring of S since it is longer
     * Then we create two hashmaps. One for the characters in T which will not change after we add all the characters of T
     * We will use this hashmap as a form of checklist to see if the sliding window contains what is needed
     * The second hashmap will be used to track the characters in the current window
     * We iterate through T and populate its hashmap then we initilize some variables
     * charHave is the number of characters in the window that are needed from T
     * charNeed is the number of unique characters in T that we need to find in the window
     * left is the left pointer of the sliding window
     * minLength is the minimum length of the substring found so far
     * res is an array that will hold the start and end indices of the minimum substring found
     * We then iterate through S with a right pointer
     * For each character in S we add it to the windowMap then check if the hashmap for T contains this character and the count in both windows is the same
     * If this is true we increment charHave by 1
     * Next we have a while loop that checks if charHave is equal to charNeed
     * while this is true we have an if statement that checks if the length of the current window is less than the minLength
     * if it is we update minLength and res meaning we have found a new minimum substring
     * Next we get the left character from the window and remove it from the windowMap
     * if the left character is in T and its count in the windowMap is less than the count in tMap we decrement charHave by 1
     * Finally we increment the left pointer to shrink the window
     * After the loop ends we check if minLength is still Integer.MAX_VALUE meaning we did not find a substring and return an empty string
     * Otherwise we return the substring from S using the indices in res
     */
    
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
        System.out.println("s = OUZODYXAZV, t = XYZ");
        System.out.println("Expected: YXAZV");
        System.out.println("Output: " + sol.minWindow("OUZODYXAZV", "XYZ"));
    }
}
