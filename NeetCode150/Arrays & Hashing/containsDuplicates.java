
import java.util.HashSet;


public class containsDuplicates {
    /*
    - Contains Duplicates simply asks if there are any duplicates in the given array.
    This brute force solution O(n^2) goes through the array in a nested for loop and checks if the current element is equal to any other element in the array.
    If it is, it returns true, if not it returns false.
    
    - A better solution would be to use a hashset since it store only unique values and has an average time complexity of O(1) for inserts and lookups.
    Therefore we go through the original array and insert each element into the hashset. If we find an element that is already in the hashset we return true.  
    If we go through the entire array without finding a duplicate we return false.
     */
    public boolean hasDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                return true;
            } else { 
                set.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        containsDuplicates sol = new containsDuplicates();
        System.out.println("Contains Duplicates Tests");
        System.out.println(" Array:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10] Solution: " + sol.hasDuplicate1(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(" Array:[1, 2, 3, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10] Solution: " + sol.hasDuplicate1(new int[]{1, 2, 3, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(" Array:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10] Solution: " + sol.hasDuplicate2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(" Array:[1, 2, 3, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10] Solution: " + sol.hasDuplicate2(new int[]{1, 2, 3, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10}));
    }
    }
