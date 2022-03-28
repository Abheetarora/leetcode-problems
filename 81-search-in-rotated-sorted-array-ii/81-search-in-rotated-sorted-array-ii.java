class Solution {
    public boolean search(int[] a, int t) {
        if(a.length==1)
            return a[0]==t;
        
        int i=0,j=1,n=a.length;
        
        while(a[i]<=a[j]){
            if(j!=n-1){
              i++;j++;   
            }
            else
                break;
        }
        
        int res1=binarySearch(a,0,i,t);
        int res2=binarySearch(a,j,n-1,t);
        
        if(res1==-1 && res2==-1)
            return false;
        else
            return true;
    }
    
     static int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
 
            if (arr[mid] == x)
                return mid;
 
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
 
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
}