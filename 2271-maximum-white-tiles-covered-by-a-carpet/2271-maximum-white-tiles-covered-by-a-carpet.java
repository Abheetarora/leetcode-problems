class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles,(a,b)->{return a[0]-b[0];});
        int cur = 0;
        int prev = 0;
        int maxcount = 0;
        int count = 0;
        
        while(cur < tiles.length)
       { 
            int start = tiles[prev][0];
            int end = tiles[cur][1];
            if(end - start + 1 <= carpetLen)
        {
            count += tiles[cur][1] - tiles[cur][0] + 1;
                maxcount = Math.max(maxcount,count);
                cur++;
        }
            else
            {
                int partial = start + carpetLen - 1;
                int s = tiles[cur][0];
                int e = tiles[cur][1];
                if(partial>=s && partial<=e)
                {
                    maxcount = Math.max(maxcount,count + partial - s +1);   
                }
                count -= tiles[prev][1] - tiles[prev][0] + 1;
                prev++;
            }
        
        }
        return maxcount;
    }
}