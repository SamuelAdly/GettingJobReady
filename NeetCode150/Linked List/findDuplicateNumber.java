import java.util.HashSet;

public class findDuplicateNumber {

    /*
     * Find the Duplicate Number is a leetcode medium problem
     * This problem was given to me in the linked list section but I think I also saw it in the arrays/hashing section
     * 
     * My first instinct was to use a hashset storing the integer I have seen yet until there is a duplicate
     * So the approach is O(n) time and O(n) space
     * We first create the integer hashset (which doesnt allow for duplicates) and then go through the array
     * if the number is in the hashset already we return that number else we add it to the hashset
     * if we find nothing we return -1 aka no duplicates
     * 
     * since it is in the linked list section then there must be an approach using linked lists and takes O(1) extra space
     * the approach does use a concept from linked lists but doesnt use the linked list data structure itself otherwise that too will be O(n) space
     * this problem requires linked list cycle detection and Floyds Tortoise and Hare algorithm
     * we first set slow and fast pointers to 0 and while true we traverse the array
     * the slow pointer moves by going to the index of the number it is on so if nums[0] = 2 we now set slow = 2
     * the fast pointer moves by going to the index of the index of the number. This means that if nums[0] = 2 and nums[2] = 3 we now set fast = 3
     * basically, fast is moving by two steps by going to the next index that slow would go to by doing nums[nums[fast]]
     * if we end up getting the same value for slow and fast then we know that there is a cycle and we break out of the loop
     * we then set the finder pointer to 0 and move both finder and slow until they meet
     * the number they meet at is the duplicate number and we return it
     */
    
    public int findDuplicateBasic(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }

    public int findDuplicateBest(int[] nums) {
        int slow = 0, fast = 0;
        while (true) { 
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        int finder = 0;
        while (finder != slow) {
            finder = nums[finder];
            slow = nums[slow];
        }
        return finder;
    }


    public static void main(String[] args) {
        findDuplicateNumber finder = new findDuplicateNumber();
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println("Duplicate number using hashset is: " + finder.findDuplicateBasic(nums));
        System.out.println("Duplicate number using slow & fast pointers is: " + finder.findDuplicateBest(nums));
    }
}
