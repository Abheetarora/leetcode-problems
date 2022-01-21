class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int arr[] = new int[gas.length];
        int sum = 0;
        for(int i=0;i<gas.length;i++)
        {
            arr[i] = gas[i] - cost[i]; 
            sum = sum + arr[i];
        }
        if(sum < 0)
        {
            return -1;
        }
        int ans = 0;
        int index = 0;
        for(int i=0;i<arr.length;i++)
        {
             ans+=arr[i];
            if(ans<0){
                ans=0;
                index=i+1;
            }
        }
        return index;
    }
}