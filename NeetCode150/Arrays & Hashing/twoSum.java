
import java.util.Arrays;
import java.util.HashMap;

/*
    Two Sum asks if there are two numbers in an array that add up to a target number. The brute force which is O(n^2) checks each combination using two for loops.
    First for loop keeps track of the first outer number and the second for loop checks each number after it to see if they add up to the target.
    The best solution is using a hashmap which takes only O(n) time.
    We start off by creating a hashmap of integer pairs so we can keep track of the number and where it lies in the array (aka the index).
    We then obviously create an array of size 2 to hold the results.
    We then loop through the array and calculate the needed number by subtracting target - current number. If that needed is in the hashmap we have found our pair.
    If not we add the current number and its index to the hashmap and continue.
 */

public class twoSum {


    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer> tracker = new HashMap<>();
        int[] results = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];
            if (tracker.containsKey(needed)) {
                results[0] = tracker.get(needed);
                results[1] = i;
            } else {
                tracker.put(nums[i], i);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        twoSum sol = new twoSum();
        System.out.println("Two Sum Tests");
        System.out.println("Test 1: nums = [3,4,5,6], target = 7" );
        System.out.println(Arrays.toString(sol.twoSum(new int[]{3,4,5,6}, 7)));
        System.out.println("Test 2: nums = [4,5,6], target = 10" );
        System.out.println(Arrays.toString(sol.twoSum(new int[]{4,5,6}, 10)));
        System.out.println("Test 3: nums = [5,5], target = 10" );
        System.out.println(Arrays.toString(sol.twoSum(new int[]{5,5}, 10)));
    }
    
}
