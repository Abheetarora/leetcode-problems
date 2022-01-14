class Solution {
    public int majorityElement(int[] arr) {
        int n = arr.length;
        int ans = arr[0];
        int freq = 1;
        for(int i =1;i<n;i++)
        {
            if(freq == 0)
            {
                ans = arr[i];
            }
            if(arr[i] == ans)
            {
                freq++;
            }
            if(arr[i]!=ans)
            {
                freq--;
            }
            
        }
        return ans;
    }
}