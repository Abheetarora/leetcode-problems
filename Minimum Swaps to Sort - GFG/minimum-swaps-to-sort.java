// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends



 class pair{
        int start;
        int end;
        pair(int start,int end)
        {
            this.start = start;
            this.end = end;
        }
        
    }
   class mysort implements Comparator<pair>
{
	public int compare(pair a1, pair a2)
	{
		return a1.start - a2.start;
	}
}
class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        ArrayList<pair> arr = new ArrayList<>();
      for(int i=0;i<nums.length;i++)
      {
          arr.add(new pair(nums[i],i));
      }
      Collections.sort(arr,new mysort());
      int c = 0;
      //System.out.print(arr.size());
      //int vis[]= new int[arr.size()];
      ArrayList<Integer> vis = new ArrayList<>();
      for(int i=0;i<arr.size();i++)
      {
          vis.add(arr.get(i).end);
      }
      for(int i=0;i<arr.size();i++)
      {
          //System.out.println(arr.get(i).end);
          if(vis.get(i) == i)
          {
          continue;
          }
          else
          {
              c++;
            //   List<int> a = Arrays.asList(vis);
              Collections.swap(vis, i, vis.get(i)); 
                // int temp = vis[i];
                // vis[i] = vis[vis[i]];
                // vis[vis[i]] = temp;
              i--;
          }
      }
      return c;
        // Code here
    }
    
}