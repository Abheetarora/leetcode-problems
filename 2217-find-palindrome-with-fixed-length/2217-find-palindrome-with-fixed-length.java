class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] ans = new long[queries.length];
        
        int power = (intLength-1)/2;
        long baseValue = (long)Math.pow(10, power);
        
        for(int i = 0; i<queries.length; i++){
            long numberX = baseValue + (queries[i]-1);
            long finalNum = numberX;
            
			// remove last digit if it's odd length, we don't need to append middle digit
            if(intLength % 2 == 1)
                numberX /= 10;
            
            while(numberX != 0){
                finalNum = (finalNum * 10) + (numberX % 10);
                numberX /= 10;
            }
            
            int n = getNumLength(finalNum);
            ans[i] = (n == intLength) ? finalNum : -1;
        }
        
        return ans;
    }

    private int getNumLength(long num){
        int ans = 0;
        while(num != 0){
            num /= 10;
            ans++;
        }
        return ans;
    }
}