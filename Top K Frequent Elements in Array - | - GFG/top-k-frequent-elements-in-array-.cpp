// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
  public:
   vector<int> topK(vector<int>& nums, int k) {
        // Code here
        int n = nums.size();

        unordered_map<int,int> mp;
        for(int i =0;i<n;i++){
            mp[nums[i]]++;
        }
        vector<pair<int,int>> v;
        for(auto x: mp){
            v.push_back(make_pair(x.second,x.first));
        }
        sort(v.begin(),v.end());
        vector<int> res;
        int l = v.size();
        for(int i =0;i<k;i++){
            res.push_back(v[l-1].second);
            l--;
        }
        return res;
    }
};


// { Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n;
        cin >> n;
        vector<int> nums(n);
        for (auto &i : nums) cin >> i;
        int k;
        cin >> k;
        Solution obj;
        vector<int> ans = obj.topK(nums, k);
        for (auto i : ans) cout << i << " ";
        cout << "\n";
    }
    return 0;
}  // } Driver Code Ends