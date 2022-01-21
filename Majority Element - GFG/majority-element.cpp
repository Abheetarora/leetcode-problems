// { Driver Code Starts
//Initial template for C++

#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function template for C++

class Solution{
  public:
     // Function to find majority element in the array
    // a: input array
    // size: size of input array
    int majorityElement(int arr[], int n)
    {
        int prev = arr[0];
        int count = 0;
        int maji = 0;
        for(int i=0;i<n;i++)
        {
           
            if(arr[i] == prev)
            {
                count++;
            }
            else
            {
                count--;
            }
            if(count == 0)
            {
                prev = arr[i];
                maji = i;
                count = 1;
            }
            
            //cout<<arr[i]<<" "<<prev<<" "<<count<<endl;
            //cout<<prev;
            
            
        }
        int glag = 0;
        for(int i=0;i<n;i++)
        {
            if(arr[i] == prev)
            {
                glag++;
            }
        }
        if(glag > n/2)
        {
            return prev;
        }
        else
        {
            return -1;
        }
        
        // your code here
        
    }
};

// { Driver Code Starts.

int main(){

    int t;
    cin >> t;

    while(t--){
        int n;
        cin >> n;
        int arr[n];
        
        for(int i = 0;i<n;i++){
            cin >> arr[i];
        }
        Solution obj;
        cout << obj.majorityElement(arr, n) << endl;
    }

    return 0;
}
  // } Driver Code Ends