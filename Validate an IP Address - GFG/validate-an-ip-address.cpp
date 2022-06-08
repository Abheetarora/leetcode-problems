// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
/* The function returns 1 if
IP string is valid else return 0
You are required to complete this method */
class Solution {
    public:
         int isValid(string s) {
           // code here
         s.push_back('.');
         int count=0;
         for(int i=0;i<s.length();i){
             if(s[i]=='.'){
                 return 0;
             }
           auto it=s.find(".");
           if(it==string::npos){
               return 0;
           }
           string st=s.substr(0,it);
           if(st.length()>3){
               return 0;
           }
           if(st[0]=='a'||st[0]=='o'){
               return 0;
           }
           long long int num=stoi(st);
           if(num==0&&st.length()>1){
               return 0;
           }else if(num!=0&&st[0]=='0'){
               return 0;
           }
           s.erase(0,it+1);
           count++;
           if(num>=0&&num<=255){
               continue;
           }else{
               return 0;
           }
           
         }
         if(count==4)
         return 1;
         else
         return 0;
       }
};

// { Driver Code Starts.

int main() {
    // your code goes here
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        Solution ob;
        cout << ob.isValid(s) << endl;
    }
    return 0;
}  // } Driver Code Ends