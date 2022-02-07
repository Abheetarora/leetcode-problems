// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
	public:
		int AlternatingaMaxLength(vector<int>&nums){
		    // Code here
		    int i = 1;
		    int j = 1;
		    for(int k=0;k<nums.size()-1;k++)
		    {
		        if(nums[k] < nums[k+1])
		        {
		            i = j+1;
		        }
		        else if(nums[k] > nums[k+1])
		        {
		            j = i+1;
		        }
		    }
		    return max(i,j);
		}

};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<int>nums(n);
		for(int i = 0; i < n; i++)
			cin >> nums[i];
		Solution obj;
		int ans = obj.AlternatingaMaxLength(nums);
		cout << ans << "\n";
	}
	return 0;
}  // } Driver Code Ends