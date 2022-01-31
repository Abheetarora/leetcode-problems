class Solution {
    public int maximumWealth(int[][] account) {
        int ans = 0;
        for(int i=0;i<account.length;i++)
        {
            int temp = 0;
            for(int j=0;j<account[0].length;j++)
            {
                temp = temp + account[i][j];
            }
            if(temp > ans)
            {
                ans = temp;
            }
        }
        return ans;
    }
}