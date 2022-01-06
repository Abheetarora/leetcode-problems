class Solution {
    public boolean carPooling(int[][] trips, int n) {
        int arr[]=  new int[1001];
        for(int i = 0; i<trips.length;i++)
        {
            int cap = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];
            arr[from] = arr[from] + cap;
            arr[to] = arr[to] + (-1*cap);
        }
        int sum = 0;
        for(int i=0;i<arr.length;i++)
        {
           sum = sum + arr[i];
               
          // System.out.println(sum);
            if(sum > n)
            {
                return false;
            }
        }
        
        return true;
    }
}