// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends

  class Solution {
 public:
 
   bool checkPalindrome(string s){
          
          int left =0;
          int right =s.size()-1;
          
          while(left<right){
              if(s[left]!=s[right]){
                  return false;
              }
              left++;
              right--;
          }
       return true;
       }
   string longestPalin (string S) {
       // code here
       string max_str;
       for(int i=0;i<S.size();i++){
           string substr;
           for(int j=i;j<S.size();j++){
               substr += S[j];
               
               if(checkPalindrome(substr)){
                   if(substr.size()>max_str.size()){
                       max_str = substr;
                   }
               }
           }
       }
       return max_str;
   }
};

// { Driver Code Starts.

int main()
{
    int t; cin >> t;
    while (t--)
    {
        string S; cin >> S;
        
        Solution ob;
        cout << ob.longestPalin (S) << endl;
    }
}
// Contributed By: Pranay Bansal
  // } Driver Code Ends