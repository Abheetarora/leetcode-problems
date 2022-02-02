// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution
{
    public:
    //Function is to check whether two strings are anagram of each other or not.
    bool isAnagram(string a, string b){
   
   int arr[26]={0};
   
   for(int i =0; a[i]!='\0';i++){
       arr[a[i]-97]+=1;
   }
   for(int i =0; b[i]!='\0';i++){
       arr[b[i]-97]+=1;
   }
   for(int i =0;i<26;i++){
       if(arr[i]%2 !=0 ){
           return false;
       }
   }
   return true;
   
}

};

// { Driver Code Starts.

int main() {
    
    int t;

    cin >> t;

    while(t--){
        string c, d;

        cin >> c >> d;
        Solution obj;
        if(obj.isAnagram(c, d)) cout << "YES" << endl;
        else cout << "NO" << endl;
    }

}
  // } Driver Code Ends