class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return ans(s,new HashSet<>(wordDict),0,new Boolean[s.length()]);
    }
    public boolean ans(String s,Set<String>dict , int start,Boolean[]dp)
    {
        if(start == s.length())
        {
            return true;
        }
        if(dp[start]!=null)
        {
            return dp[start];
        }
        for(int i=start+1;i<=s.length();i++)
        {
            if(dict.contains(s.substring(start,i)) && ans(s,dict,i,dp))
            {
                return dp[start] = true;
            }
        }
        return dp[start] = false;
    }
} 