class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int r = arr.length-1;
        int c = 0;

        while (r >= 0 && c < arr[0].length) {
            if (arr[r][c] > target) {
                r--;
            } else if (arr[r][c] < target) {
                c++;
            } else {
                return true;
            }
        }

        return false;
    }
}