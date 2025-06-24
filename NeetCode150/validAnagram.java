
import java.util.Arrays;
import java.util.HashMap;

public class validAnagram {
    /*
    Valid Anagram asks if two strings are anagrams of each other. This means that they contain the same characters.
    The brute force solution which is O(n log n + m log m) checks if they are the same length first.
    Then it puts the strings in character arrays and sorts them. Then it compares them to see if they are equal because if they are anagrams the characters will be the same sorted.

    - A better solution is to use a hashmap. This solution is O(n + m) time. 
    We first check the lengths of the strings like last time.
    Then we create two hashmaps to store the characters and their frequencies.
    We use a for loop to go through the two strings and populate the hashmaps.
    We then compare the two hashmaps to see if they are equal. If they are, they are anagrams. If not, they are not.
     */
    public boolean isAnagram1 (String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();

        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }

    public boolean isAnagram2 (String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap <Character, Integer> map1 = new HashMap<>();
        HashMap <Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i <s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }
        return map1.equals(map2);
    }

    public static void main(String[] args) {
        validAnagram sol = new validAnagram();
        System.out.println("Valid Anagram Tests");
        System.out.println("s: anagram t: nagaram Solution: " + sol.isAnagram1("anagram", "nagaram"));
        System.out.println("s: ant t: bat Solution: " + sol.isAnagram1("ant", "bat"));
        System.out.println("s: anagram t: nagaram Solution: " + sol.isAnagram2("anagram", "nagaram"));
        System.out.println("s: ant t: bat Solution: " + sol.isAnagram2("ant", "bat"));
    }
}
