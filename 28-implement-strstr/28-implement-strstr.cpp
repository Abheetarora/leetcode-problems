class Solution {
public:
    int strStr(string haystack, string needle) {
        int a=0;
        if(needle.length()==0)
        return 0;
        else{
              for(int i=0;i<haystack.length();i++)
                     {   if(haystack[i]==needle[0])
                             {
                                 a=haystack.find(needle,i);
                                 if(a>=0)
                                     break;
                              }
                         else 
                             a=-1;
                     }
              }
        if(haystack.length()==0)
            a=-1;
        return a;
    }
};