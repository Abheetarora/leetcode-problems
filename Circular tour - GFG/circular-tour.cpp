// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

struct petrolPump
{
    int petrol;
    int distance;
};


 // } Driver Code Ends
/*
The structure of petrolPump is 
struct petrolPump
{
    int petrol;
    int distance;
};*/

/*You are required to complete this method*/
class Solution{
  public:
  
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
   int tour(petrolPump p[],int n)
    {
        int psum = 0;
        int ans = 0;
        int sum1=0;
        int sum2=0;
        for(int i=0;i<n;i++)
        {
            sum1 += p[i].petrol;
            sum2 += p[i].distance;
            if(psum+p[i].petrol < p[i].distance)
            {
                ans = i+1;
                psum = 0;
            }
            else
            psum = psum+p[i].petrol - p[i].distance;
        }
        if(ans>=n || sum2>sum1)
        return -1;
        else
        return ans;
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
        cin>>n;
        petrolPump p[n];
        for(int i=0;i<n;i++)
            cin>>p[i].petrol>>p[i].distance;
        Solution obj;
        cout<<obj.tour(p,n)<<endl;
    }
}
  // } Driver Code Ends