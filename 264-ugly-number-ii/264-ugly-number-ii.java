class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        int i2=0,i3=0,i5=0;
        Map<Integer,Boolean> hash = new HashMap<>();
        int next_2 = dp[i2]*2;
        int next_3 = dp[i3]*3;
        int next_5 = dp[i5]*5;
        for(int i=1;i<n;){
            int next = mini(next_2,next_3,next_5);
            if(null == hash.get(next)){
                dp[i++] = next;
                hash.put(next,true);
            }
            if(next == next_2){
                next_2 = dp[++i2]*2;
            }
            else if(next == next_3){
                next_3 = dp[++i3]*3;
            }
            else{
                next_5 = dp[++i5]*5;
            }
            
        }
        return dp[n-1];
    }
    private int mini(int a,int b,int c){
        return a<b?(a<c?a:c):(b<c?b:c);
    }
}