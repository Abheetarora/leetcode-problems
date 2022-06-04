class Solution {
    public int size;
    public List<List<String>> solutions = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        size = n;
        char emptyBoard[][] = new char[size][size];
        for(int i=0;i<n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                emptyBoard[i][j] = '.';
            }
        }
        solve(0,new HashSet<>(),new HashSet<>(),new HashSet<>(),emptyBoard);
        return solutions;
    }
    
      public List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<String>();
        for (int row = 0; row < size; row++) {
            String current_row = new String(state[row]);
            board.add(current_row);
        }
        
        return board;
    }
    
    
    public void solve(int row,Set<Integer>diagonals,Set<Integer>antiDiagonals,Set<Integer>cols,char[][]state)
    {
        if(row == size)
        {
            solutions.add(createBoard(state));
        }
        for(int col=0;col<size;col++)
        {
            int currDiagonal = row-col;
            int currAntiDiagonal = row+col;
            if(cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal))
            {
                continue;
            }
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);
            state[row][col] = 'Q';
            solve(row+1,diagonals,antiDiagonals,cols,state);
            //remove the queen from the board since we have explored it.
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
            state[row][col] = '.';
        }
    }
    
}