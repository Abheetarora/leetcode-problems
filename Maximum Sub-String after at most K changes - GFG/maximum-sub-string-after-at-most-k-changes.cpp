// { Driver Code Starts

#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends

class Solution {
	public:
	
		int characterReplacement(string s, int k){
		    int j=0,maxrepetcount=0,maxlen=0;
		    unordered_map<char,int>fm;
		    for(int i=0;i<s.length();i++){
		        char rc = s[i];
		        fm[rc]++;
		        maxrepetcount = max(maxrepetcount,fm[rc]);
		        if(i-j+1-maxrepetcount > k){
		            //shrink the window
		            char lc = s[j];
		            fm[lc]--;
		            j++;
		        }
		        maxlen = max(maxlen,i-j+1);
		    }
		    return maxlen;
		}

};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		string s;
		cin >> s;
		int k;
		cin >> k;
		Solution obj;
		int ans = obj.characterReplacement(s, k);
		cout << ans << "\n";
	}
	return 0;
}  // } Driver Code Ends