class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for (int i = 0;i<n;i++){
            long low = nums[i];
            long high = nums[i];
            for (int j = i+1;j<n;j++){
                low = Math.min(low, nums[j]);
                high = Math.max(high,nums[j]);
                ans += high - low;
            }
        }
        return ans;
    }
}