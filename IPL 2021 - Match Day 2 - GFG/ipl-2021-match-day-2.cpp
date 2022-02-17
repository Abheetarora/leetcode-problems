// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution {
  public:
    vector<int> max_of_subarrays(vector<int> arr, int n, int k) {
        // your code here
            // your code here
       priority_queue<pair<int,int> >  pq;
       int i=0;
       vector<int> res;
       for(i=0;i<k-1;i++) pq.push({arr[i],i});
       for( ; i < n ; i ++){
           pq.push({arr[i],i});
           while(pq.top().second<=i-k) pq.pop();
           // cout<<pq.top().first<<" ";
           res.push_back(pq.top().first);
       }
       return res;
    }
};

// { Driver Code Starts.

int main() {

    int t;
    cin >> t;

    while (t--) {

        int n, k;
        cin >> n >> k;

        vector<int> arr(n);
        for (int i = 0; i < n; i++) cin >> arr[i];
        Solution ob;
        vector<int> res = ob.max_of_subarrays(arr, n, k);
        for (int i = 0; i < res.size(); i++) cout << res[i] << " ";
        cout << endl;
    }

    return 0;
}  // } Driver Code Ends