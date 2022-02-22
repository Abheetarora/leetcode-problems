class Solution {
    public int titleToNumber(String s) {
        int ans = 0;
        int p =0;
        for(int i = s.length()-1;i>=0;i--)
        {
            int x = s.charAt(i)-'A' + 1;
            x = x*(int)(Math.pow(26,p));
            ans = ans + x;
            p++;
        }
       
        return ans;
    }
}
