import java.util.HashMap;

class longestRepeatingCharacterReplacement {
    /*
     * Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
     * These K operations are switching the character at a given index to make it so that you have a longer repeating character sequence.
     * You need to find the length of the longest repeating character sequence that you can achieve after performing at most k operations.
     * This method does this in O(n) time complexity and O(m) space complexity where m is the number of unique characters in the string.
     * The algorithm uses a sliding window approach.
     * We create a hashmap that takes the character as the key and the number of times it appears in the current window as the value.
     * we keep track of the maximum frequency of any character in the current window and the maximum length of the longest repeating character sequence.
     * We initialize these variables to 0 as well as the left pointer of the sliding window.
     * We then loop through the string where i can be thought of as the right pointer of the sliding window.
     * for each character we add it to the hashmap or update the value if it already exists.
     * We then update the maximum frequency tracker
     * and check if the current window size minus the maximum frequency is greater than k. (this means that our window has more than k characters that are not the most frequent character and so we cant change these more than K characters to make it the max frequency).
     * if it is, we remove the character at the left pointer from the hashmap and increment the left pointer by 1.
     * We then update the maximum length if the current window size is greater than the previous maximum length.
     */

    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> charCounter = new HashMap<>();
        int max = 0, left = 0, maxFreq = 0;
        for (int i = 0; i < s.length(); i++) {
            charCounter.put(s.charAt(i), charCounter.getOrDefault(s.charAt(i), 0) + 1);
            maxFreq = Math.max(maxFreq, charCounter.get(s.charAt(i)));

            while ((i - left + 1) - maxFreq > k) {
                charCounter.put(s.charAt(left), charCounter.get(s.charAt(left)) - 1);
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        longestRepeatingCharacterReplacement sol = new longestRepeatingCharacterReplacement();
        System.out.println("Test of O(n) solution:");
        System.out.println("s = XYYX, k = 2");
        System.out.println("Expected: 4");
        System.out.println("Output: " + sol.characterReplacement("XYYX", 2));
        System.out.println("s = AAABABB, k = 1");
        System.out.println("Expected: 5");
        System.out.println("Output: " + sol.characterReplacement("AAABABB", 1));
        System.out.println("s = ABAB, k = 2");
        System.out.println("Expected: 4");
        System.out.println("Output: " + sol.characterReplacement("ABAB", 2));
        System.out.println("s = ABBB, k = 1");
        System.out.println("Expected: 4");
        System.out.println("Output: " + sol.characterReplacement("ABBB", 1));

    }
}