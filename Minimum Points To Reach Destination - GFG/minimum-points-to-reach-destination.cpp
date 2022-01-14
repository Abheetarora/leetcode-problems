// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution{

	public:
	int minPoints(vector<vector<int>> points, int M, int N) 
	{
	    int dp[M][N];
	    dp[M-1][N-1] = 0;
	    if(points[M-1][N-1]<0) dp[M-1][N-1] = points[M-1][N-1];
	    for(int i=M-1; i>=0; i--) {
	        for(int j=N-1; j>=0; j--) {
	            if(i==M-1 && j==N-1) continue;
	            if(i+1<M && j+1<N) {
	                dp[i][j] = points[i][j] + max(dp[i+1][j], dp[i][j+1]);
	                if(dp[i][j]>0) dp[i][j] = 0;
	            }
	            else if(i+1<M) {
	                dp[i][j] = points[i][j] + dp[i+1][j];
	                if(dp[i][j]>0) dp[i][j] = 0;
	            }
	            else if(j+1<N) {
	                dp[i][j] = points[i][j] + dp[i][j+1];
	                if(dp[i][j]>0) dp[i][j] = 0;
	            }
	        }
	    }
	    return abs(dp[0][0])+1;
	}
};


// { Driver Code Starts.
int main() 
{
   
   	int t;
    cin >> t;
    while (t--)
    {
        int m, n;
        cin >> m >> n;

        vector<vector<int>> a(m, vector<int>(n));

        for(int i = 0; i < m; i++)
        	for(int j = 0; j < n; j++)
        		cin >> a[i][j];

        

	    Solution ob;
	    cout << ob.minPoints(a, m, n) << "\n";
	     
    }
    return 0;
}
  // } Driver Code Ends