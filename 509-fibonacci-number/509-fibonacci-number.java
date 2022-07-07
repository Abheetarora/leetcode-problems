class Solution {
    public int fib(int n) {
        int a = 1;
        int b = 0;
        int ans = 0;
        while(n-->0)
        {
            b = a;
            a = ans;
            ans = a+b;
            //System.out.println(ans);
        }
        return ans;
    }
}