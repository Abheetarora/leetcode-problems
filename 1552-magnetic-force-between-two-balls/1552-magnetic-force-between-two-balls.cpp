class Solution {
public:
    int checkCows(int n,int mid,int arr[],int c)
{
	int coordinate = arr[0];
	int count = 1;
	for(int i=1;i<n;i++)
	{
		if(arr[i] - coordinate >= mid)
		{
			count++;
			coordinate = arr[i];
		}
		if( count == c)
		{
			return true;
		}
	}
	return false;
}
    int maxDistance(vector<int>& position, int c) {
       
    int arr[position.size()];
        for(int i=0;i<position.size();i++)
        {
            arr[i] = position[i];
        }
        int n = position.size();
		sort(arr,arr+position.size());
		int hi = arr[n-1] - arr[0] ,lo = 1;
		int result = 0;
		while(lo<=hi)
		{
			int mid = (hi+lo)/2;
			if(checkCows(n,mid,arr,c)==true)
			{
				result = mid;
				lo = mid + 1;
			}
			else
			{
				hi = mid-1;
			}
		}
		//cout<<result<<endl;
		return result; 
    }
};