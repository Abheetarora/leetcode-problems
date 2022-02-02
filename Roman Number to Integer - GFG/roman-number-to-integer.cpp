// { Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function template for C++

class Solution {
  public:
    int romanToDecimal(string &s) {
       // code here
       map<char,int>mp;
       mp.insert(pair<char,int>('I',1));
       mp.insert(pair<char,int>('V',5));
       mp.insert(pair<char,int>('X',10));
       mp.insert(pair<char,int>('L',50));
       mp.insert(pair<char,int>('C',100));
       mp.insert(pair<char,int>('D',500));
       mp.insert(pair<char,int>('M',1000));
       int len=s.size();
       int sum;
       int res=0;
       for(int i=0;i<len;)
       {
           if(i==(len-1) || mp[s[i]]>=mp[s[i+1]])
           {
               sum=mp[s[i]];
               i++;
           }
           else{
               sum=mp[s[i+1]]-mp[s[i]];
               i=i+2;
           }
           res=res+sum;
       }
       return res;
       
   }
};

// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        Solution ob;
        cout << ob.romanToDecimal(s) << endl;
    }
}  // } Driver Code Ends