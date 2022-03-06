// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution
{
    public:
    //Function to find a continuous sub-array which adds up to a given number.
    vector<int> subarraySum(int arr[], int n, long long s)
    {
        vector<int> ans;
        // Your code here
      //  long long currSum = arr[0];
        int start = 0;
        int end = 0;
        long long currSum = arr[start];
        while(start < n){
            if(currSum == s){
                ans.push_back(start+1);
                ans.push_back(end+1);
                return ans;
            }
           
                else if(currSum > s){
                    currSum -= arr[start];
                    start++;
                }
                else if(currSum < s){
                     end++;
                    currSum +=arr[end];
                }
             
    
        }
        return {-1};
    }
};

// { Driver Code Starts.

int main()
 {
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        long long s;
        cin>>n>>s;
        int arr[n];
        const int mx = 1e9;
        for(int i=0;i<n;i++)
        {
            cin>>arr[i];
        }
        Solution ob;
        vector<int>res;
        res = ob.subarraySum(arr, n, s);
        
        for(int i = 0;i<res.size();i++)
            cout<<res[i]<<" ";
        cout<<endl;
        
    }
	return 0;
}  // } Driver Code Ends