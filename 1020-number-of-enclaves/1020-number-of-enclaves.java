class Solution {
    int[][]directions= {{-1,0},{1,0},{0,-1},{0,1}};
    public int numEnclaves(int[][] grid) {
        int[][]result= new int[grid.length][grid[0].length];
        int count=0;
        Queue<int[]>q= new LinkedList();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                 if((i == 0 || j == 0 || i == grid.length- 1 || j == grid[0].length - 1) && grid[i][j] == 1){
                   
                    //count++;
                    q.add(new int[]{i,j});
                     result[i][j]=1;
                }
                // else if(grid[i][j]==1){
                //     count++;
                // }
            }
            }
      
            while(!q.isEmpty()){
                int size=q.size();
                
                int[]cur= q.remove();
                int rr=cur[0];
                int rc=cur[1];
                for(int[]direction:directions){
                    int nr= rr+direction[0];
                    int nc= rc+direction[1];
                     if (!isOutOfBounds(grid, nr,nc) && result[nr][nc]==0 ){
                    if(grid[nr][nc]==1){
                       result[nr][nc]=1;
                        q.add(new int[]{nr,nc});
                    }
                     }
                     }
                
            

        }
        int m=count(grid,result);
                    return m;
    }
    public boolean isboundary(int[][]grid,int i,int j){
        if(grid[0][j]==1|| grid[i][0]==1||grid[grid.length-1][j]==1|| grid[i][grid.length-1]==1){
            return true;
        }
        return false;
    }
     private boolean isOutOfBounds(int[][] mat, int row, int col){
        return (row<0 || row>=mat.length || col<0 || col>=mat[0].length);
    }
    public int count(int[][]grid,int[][]result){
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && result[i][j]==0){
                    count++;
                }
            }
            
        }
        return count;
    }
}