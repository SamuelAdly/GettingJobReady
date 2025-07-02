public class kokoEatingBananas {

    /*
    - The koko eating bananas problems ask that given an array of piles of bananas and a number of hours h that you must complete the task in, we have to find the minimum number of bananas per hour that Kok can eat
    - For this approach you can brute force it by checking every possible number of bananas per hour from 1 to the maximum number of bananas in the piles and checking if it is possible to finish all the piles in h hours.
    - A better approach is to use binary search on that range of 1 to the max keeping track of the minimum result as we go along.
    - Below I find the max of the array. Then I set up my left and right pointers as well as the minimum result variable. I then go through the binary search process. I calculate the total time and keep track of the best time so far.
    - If the time is less than or equal to h we know that we need to eat at a slower speed but that time is good for now. If have a time higher than h we know that we need to eat faster so we move to the upper half of that range.
    */
    public int minEatingSpeed(int[] piles, int h) {
        //im finding the max of the array
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        //binary search from 1 to max to find the minimum bananas per hour
            int left = 1;
            int right = max;
            int minimum = 0;
            while (left <= right) {
                int k = (left + right) / 2;
                long time = 0;
                for (int i = 0; i < piles.length; i++) {
                    time += Math.ceil((double) piles[i] / k);
                }
                if (time <= h) {
                    minimum = k;
                    right = k - 1;
                } else {
                    left = k + 1;
                }
            }
        return minimum;
    }







    public static void main(String[] args) {
        kokoEatingBananas sol = new kokoEatingBananas();
        System.out.println("Koko Eating Bananas Tests");
        System.out.println(" Piles:[1,4,3,2], H:9 Solution: " + sol.minEatingSpeed(new int[]{1,4,3,2}, 9));
        System.out.println(" Piles:[25,10,23,4], H:4 Solution: " + sol.minEatingSpeed(new int[]{25,10,23,4}, 4));
    }
}
