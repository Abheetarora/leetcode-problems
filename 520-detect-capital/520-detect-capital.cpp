class Solution {
public:
    bool detectCapitalUse(string word) {
       int n = word.length();
        int capital = 0;
        int small = 0;
        for(int i=0;i<n;i++)
        {
            if(word[i] >= 'A' && word[i] <= 'Z')
            {
                capital++;
            }
            else if(word[i] >= 'a' && word[i] <= 'z')
            {
                small++;
            } 
        }
        if(capital == n || small == n)
        {
            return true;
        }
        else if( word[0] >= 'A' && word[0] <= 'Z' && capital == 1)
        {
            return true;
        }
        return false;
    }
};