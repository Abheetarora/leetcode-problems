class Solution {
    public int minPartitions(String n) {
        int mx = Integer.MIN_VALUE;
        for(int i=0;i<n.length();i++)
        {
            mx = Math.max(mx,n.charAt(i)-'0');
            //System.out.println(mx);
        }
        return mx;
    }
}