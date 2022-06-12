
 class Solution {
    public int jump(int[] nums) {
        int jumps = 0, current = 0, far = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            far = Math.max(far, i + nums[i]);
            if (i == current) {
                jumps++;
                current = far;
            }
        }
        return jumps;
    }
}
