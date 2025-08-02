
public class permutationInString {

    /*
     * Permutation in string is a sliding window medium leetcode problem
     * Given two strings s1 and s2 we must return true if s2 contains a permutation of s1
     * This means that s2 contains all the characters of s1 in any order but they must be together in a substring
     * The O(n) time complexity solution uses the sliding window technique
     * We first remove the edge case where s1 is longer than s2 since it must be a substring of s2
     * Then we create two arrays of size 26 for s1 and s2 since we are only using lowercase letters
     * Now we begin our first window iteration by mapping the characters of s1 and the first window of s2 to the arrays
     * We then check the values of the two arrays to see if they match. If they dont we set match to false and break since there is no point in checking further if one character has an unequal count
     * If the first window matches we return true otherwise continue sliding the window
     * We start a for loop at the end of the first window and iterate through s2
     * We add the character at i to the s2 array count and remove the character at i - s1.length() from the s2 array count
     * We then check the two arrays again for a match and if they match we return true
     * If we finish the loop without finding a match we return false
     */
    
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int mapS1[] = new int[26];
        int mapS2[] = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            mapS1[s1.charAt(i) - 'a']++;
            mapS2[s2.charAt(i) - 'a']++;
        }

        boolean match = true;
        for (int i = 0; i < 26; i++) {
            if (mapS1[i] != mapS2[i]) {
                match = false;
                break;
            }
        }
        if (match) return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            mapS2[s2.charAt(i) - 'a']++;
            mapS2[s2.charAt(i - s1.length()) - 'a']--;
            match = true;
            for (int j = 0; j < 26; j++) {
                if (mapS1[j] != mapS2[j]) {
                    match = false;
                    break;
                }
            }
            if (match) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        permutationInString sol = new permutationInString();
        System.out.println("Test of O(n) solution:");
        System.out.println("s1 = abc, s2 = lecabee");
        System.out.println("Expected: true");
        System.out.println("Output: " + sol.checkInclusion("abc", "lecabee"));
        System.out.println("s1 = abc, s2 = lecaabee");
        System.out.println("Expected: false");
        System.out.println("Output: " + sol.checkInclusion("abc", "lecaabee"));
    }
}
