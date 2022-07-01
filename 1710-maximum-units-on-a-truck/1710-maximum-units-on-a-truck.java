class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1],a[1]));
       // System.out.println(boxTypes[0][1]);
        int cur = 0;
        int ans = 0;
       while(truckSize>0 && cur<boxTypes.length)
       {
           int p = Math.min(truckSize,boxTypes[cur][0]);
           ans = ans + p*boxTypes[cur][1];
           boxTypes[cur][0] = boxTypes[cur][0] - p;
           if(boxTypes[cur][0] == 0)
           {
               cur++;
           }
           truckSize = truckSize - p;
           
       }
        return ans;
    }
}