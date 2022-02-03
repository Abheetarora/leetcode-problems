class Solution {
    public String longestCommonPrefix(String[] s) {
        int ans = Integer.MAX_VALUE;
       for(int i=0;i<s.length;i++)
       {
           int j = 0;
           int mn = Math.min(s[0].length(),s[i].length());
           //System.out.println(mn + s[i]);
           while( mn > 0 && s[i].charAt(j) == s[0].charAt(j))
           {
               
               j++;
               mn--;
           }
           
           ans = Math.min(ans,j);
       }
        
        return s[0].substring(0,ans);
    }
}