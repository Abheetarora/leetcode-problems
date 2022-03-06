class Solution {
    public int countOrders(int n) {
        int arr[] = new int[n+1];
        if(n <=1)
        {
            return n;
        }
         int MOD = 1_000_000_007;
        arr[0] = 0;
        arr[1] = 1;
     
        for(int i=2;i<=n;i++)
        {
            long res = ((2*i)-1)*i;
            res = res*(long)arr[i-1];
            
           
            
            arr[i] = (int)(res%MOD);
            
        }
        return (int)arr[n];
    }
}