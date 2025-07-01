public class search2dMatrix {

    /*
    - Search 2D Matrix asks if a target value exists in a 2D matrix that is sorted in ascending order both row-wise and column-wise.
    - The brute force solution would be to iterate through the entire matrix one by one and check if the current element is equal to the target.
    - A solution I am thinking of implementing is that since it is sorted, I can go by column. So if i start at the top right corner of the matrix, i go down the column if the target is greater and i go through the current row if the target is smaller.
    - Another solution would be to do binary search
     */
    public boolean searchMatrixBrute(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++ ) {
            for (int j = 0; j <matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrixBetter (int [][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix[0].length - 1] >= target) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == target) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public boolean searchMatrixBest (int [][] matrix, int target) {
        int topRow = 0;
        int bottomRow = matrix.length - 1;
        while (topRow <= bottomRow) {
            int midRow = topRow + (bottomRow - topRow) / 2;
            if (matrix[midRow][0] <= target && matrix[midRow][matrix[0].length - 1] >= target) {
                int left = 0;
                int right = matrix[midRow].length - 1;
                while (left <= right) {
                    int midCol = left + (right - left) / 2;
                    if (matrix[midRow][midCol] == target) {
                        return true;
                    } else if (matrix[midRow][midCol] < target) {
                        left = midCol + 1;
                    } else {
                        right = midCol - 1;
                    }
                }
                return false;
            } else if (matrix[midRow][0] > target) {
                bottomRow = midRow - 1;
            } else {
                topRow = midRow + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        search2dMatrix sol = new search2dMatrix();
        int [][] matrix = {
        {1, 2, 4, 8}, 
        {10, 11, 12, 13}, 
        {14, 20, 30, 40}};
        int target = 10;
        System.out.println("Search 2D Matrix Tests");
        System.out.println("Brute Force Solution (O(m * n)): " + sol.searchMatrixBrute(matrix, target));
        System.out.println("Better Solution (O(m + n)): " + sol.searchMatrixBetter(matrix, target));
        System.out.println("Best Solution O(log(m * n)): " + sol.searchMatrixBest(matrix, target));
    }
}
