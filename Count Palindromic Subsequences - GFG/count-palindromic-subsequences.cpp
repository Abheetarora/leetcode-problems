// { Driver Code Starts
// Counts Palindromic Subsequence in a given String
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution{
    public:
    /*You are required to complete below method */
    const int MOD = 1e9 + 7;
   long long int countPS(string s)
{
int n = s.size();

int dp[n][n]{};

for(int i = n - 1; i >= 0; i--) // ending position
{
dp[i][i] = (s[i] == s[i]);
for(int j = i + 1; j < n; j++) // starting position
{
dp[i][j] = (dp[i + 1][j] + dp[i][j - 1]) % MOD;
if(s[i] == s[j])
dp[i][j]++;
else
dp[i][j] = (MOD + dp[i][j] - dp[i + 1][j - 1]) % MOD;
}
}

return dp[0][n - 1];
}
     
};

// { Driver Code Starts.
// Driver program
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        string str;
        cin>>str;
        Solution ob;
        long long int ans = ob.countPS(str);
        cout<<ans<<endl;
    } 
}  // } Driver Code Ends