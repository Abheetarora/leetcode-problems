class Solution {
    public boolean divisorGame(int n) {
       if(n == 1)
       {
           return false;
       }
        if(n == 2)
        {
            return true;
        }
        for(int i=1;i<n;i++)
        {
           return !(divisorGame(n-i));
        }
        return false;
        
    }
}