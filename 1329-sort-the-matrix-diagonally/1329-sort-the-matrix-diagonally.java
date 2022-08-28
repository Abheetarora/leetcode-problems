class Solution {
    public int[][] diagonalSort(int[][] mat) {
        // Store the matrix dimensions
        int m = mat.length;
        int n = mat[0].length;
   
        Map<Integer, Queue<Integer>> diagonals = new HashMap<>();
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) { 
                diagonals.putIfAbsent(row - col, new PriorityQueue<>());
                diagonals.get(row - col).add(mat[row][col]);
            }   
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                mat[row][col] = diagonals.get(row - col).remove();
            }
        }
        
        return mat;
    }
}