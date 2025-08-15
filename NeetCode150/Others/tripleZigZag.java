import java.util.Arrays;

class tripleZigZag {

    /* THE QUESTION
     * Let's say a triple (a, b, c) is a zigzag if either a < b > c or a > b < c.

Given an array of integers numbers, your task is to check all the triples of its consecutive elements for being a zigzag. More formally, your task is to construct an array of length numbers.length - 2, where the ith element of the output array equals 1 if the triple (numbers[i], numbers[i + 1], numbers[i + 2]) is a zigzag, and 0 otherwise.

Example

For numbers = [1, 2, 1, 3, 4], the output should be solution(numbers) = [1, 1, 0].

(numbers[0], numbers[1], numbers[2]) = (1, 2, 1) is a zigzag, because 1 < 2 > 1;
(numbers[1], numbers[2] , numbers[3]) = (2, 1, 3) is a zigzag, because 2 > 1 < 3;
(numbers[2], numbers[3] , numbers[4]) = (1, 3, 4) is not a zigzag, because 1 < 3 < 4;
For numbers = [1, 2, 3, 4], the output should be solution(numbers) = [0, 0];

Since all the elements of numbers are increasing, there are no zigzags.
     */

    public static int[] solution(int[] numbers) {
    int[] solutions = new int[numbers.length - 2];
    
    for (int i = 0; i < numbers.length - 2; i++) {
        if ((numbers[i] < numbers[i+1] && numbers[i+1] > numbers[i+2]) || (numbers[i] > numbers[i+1] && numbers[i+1] < numbers[i+2])) {
            solutions[i] = 1;
        }
    }
    return solutions;
}
    public static void main(String[] args) {
        int[] test1 = {1, 2, 1, 3, 4};
        System.out.println( "Test of triple zigzag solution:");
        System.out.println("Test 1: \n" + "Expected: [1, 1, 0]\n" + "Actual: " + Arrays.toString(solution(test1)));

        int[] test2 = {1, 2, 3, 4};
        System.out.println("Test 2: \n" + "Expected: [0, 0]\n" + "Actual: " + Arrays.toString(solution(test2)));
    }
}