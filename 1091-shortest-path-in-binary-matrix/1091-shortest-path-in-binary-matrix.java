
class Pair{
    int x , y;
    public Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    static boolean[][] visited;
    static int ROW , COL;
    static int[] dRow = {-1,-1,0,1,1,1,0,-1};
    static int[] dCol = {0,1,1,1,0,-1,-1,-1};
    public int shortestPathBinaryMatrix(int[][] maze){
        int entrance[] = new int[2];
        entrance[0] = entrance[1] = 0;
        if(maze[0][0]==1)
        {
            return -1;
        }
        ROW = maze.length;
        COL = maze[0].length;
        visited = new boolean[ROW][COL];
        int res = BFS(maze,entrance);
        return res;
    }
    public static boolean isValid(int[][] maze,int i,int j){
        
        if(i >= ROW || j >= COL || i < 0 || j < 0){
            return false;
        }
        if(visited[i][j]){
            return false;
        }
        if(maze[i][j] == 1){
            return false;
        }
        return true;
    }
    public static int BFS(int[][]maze,int[] entrance){
        Queue <Pair> q = new LinkedList<>();
        Pair start = new Pair(entrance[0],entrance[1]);
        q.add(start);
        q.add(null);
        visited[entrance[0]][entrance[1]] = true;
        int count = 0;
        while(!q.isEmpty()){
            Pair currCell = q.poll();
            if(currCell == null){
                if(!q.isEmpty()){
                    q.add(null);
                    count++;
                }
                continue;
            }
            int x = currCell.x;
            int y = currCell.y;
            if((x == ROW-1 && y == COL-1)){
                return count+1;
            }
            for(int i = 0; i < 8; i++){
                int adjX = x + dRow[i];
                int adjY = y + dCol[i];
                if(isValid(maze,adjX,adjY)){
                    q.add(new Pair(adjX,adjY));
                    visited[adjX][adjY] = true;
                }
            }
        }
        return -1;
    }
}