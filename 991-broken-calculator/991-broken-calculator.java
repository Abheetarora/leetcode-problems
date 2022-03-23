class Solution {
    public int brokenCalc(int n, int target) {
        int count=0;
        while(target>n)
        {
            count++;
            if(target%2==0)
            {
                target = target/2;
            }
            else
            {
                target++;
            }
        }
        return count + n - target ;
    }
}