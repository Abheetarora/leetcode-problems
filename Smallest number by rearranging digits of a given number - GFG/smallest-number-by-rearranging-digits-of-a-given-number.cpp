// { Driver Code Starts


#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends


class Solution{
	public:
   	
   	    string minimum_Number(string s){
   	    sort(s.begin(),s.end());
   	    int n=s.size();
   	    if(s[n-1]=='0'){
   	        return s;
   	    }
   	    int i=0;
   	    while(s[i]=='0'){
   	        i++;
   	    }
   	    swap(s[i],s[0]);
   	    return s;
} 
   	    // Code here
   	   
};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		string s;
		cin >> s;
		Solution ob;
		string ans = ob.minimum_Number(s);
		cout << ans <<"\n";
	}  
	return 0;
}  // } Driver Code Ends