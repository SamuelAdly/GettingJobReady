import java.util.HashSet;
import java.util.Set;
public class longestSubstringNotRepeating {
    /*
     * Longest Substring Without Repeating Characters is marked as a medium Sliding Window Problem.
     * We want to find the length of the longest substring without repeating characters.
     * The first method I came up with will result in an O(n) time complexity but will require O(m) space complexity where m is the number of unique characters in the string.
     * I will use the sliding window method to have a left and right pointer.
     * The left pointer will be the start of the unique substring and the right pointer will be the end and it will check if the character at the right pointer is already in the substring.
     * I will use a HashSet to store the characters in the substring.
     * If the character at the right pointer is not in the HashSet, I will add it to the HashSet and move the right pointer to the right.
     * If the character at the right pointer is already in the HashSet, I will remove the character at the left pointer from the HashSet and move the left pointer to the right
     * This will ensure that the substring is always unique.
     * I will keep track of the maximum length of the substring and return it at the end
     */

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, left = 0, right = 0;
        Set<Character> uniqueChars = new HashSet<>();

        while (right < s.length()) {
            if (uniqueChars.contains(s.charAt(right)) == false) {
                uniqueChars.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                uniqueChars.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        longestSubstringNotRepeating sol = new longestSubstringNotRepeating();
        System.out.println("Test of lengthOfLongestSubstring (O(n)):");
        System.out.println("s = zxyzxyz");
        System.out.println("Expected: 3");
        System.out.println("Actual: " + sol.lengthOfLongestSubstring("zxyzxyz"));
        System.out.println("s = xxxx");
        System.out.println("Expected: 1");
        System.out.println("Actual: " + sol.lengthOfLongestSubstring("xxxx"));
        System.out.println("s = abcabcbb");
        System.out.println("Expected: 3");
        System.out.println("Actual: " + sol.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("s=  ");
        System.out.println("Expected: 1");
        System.out.println("Actual: " + sol.lengthOfLongestSubstring(" "));


    }
    
}
