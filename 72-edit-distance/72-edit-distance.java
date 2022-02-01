class Solution {
    public int minDistance(String word1, String word2) {
        return editDistance(word1,word2);
    }
     public int editDistance(String s, String t) {
        // Code here
        int dp[][] = new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<t.length();j++)
            {
                dp[i][j] = -1;
            }
        }
        return ans(s,t,0,0,dp);
        
    }
    public int ans(String s,String t,int i,int j,int dp[][])
    {
       if( i >= s.length())
       {
           return t.length() - j;
       }
       if( j >= t.length())
       {
           return s.length() - i;
       }
       if(dp[i][j]!=-1)
       {
           return dp[i][j];
       }
       if(s.charAt(i) == t.charAt(j))
       {
           return dp[i][j] = ans(s,t,i+1,j+1,dp);
       }
       else
       {
           int insert = ans( s,t,i,j+1,dp );
           int delete = ans( s,t,i+1,j,dp );
           int update = ans( s,t,i+1,j+1,dp );
           return dp[i][j] =1 + Math.min(insert,Math.min(delete,update));
       }
       
        
    }
}