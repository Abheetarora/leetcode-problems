// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t > 0)
	    {
	        int n= Integer.parseInt(br.readLine().trim());
	        String x = br.readLine().trim();
	        String string_list[] = x.split(" ",n);
	        
	        Solution ob = new  Solution();
	        
	        List <List<String>> ans = ob.Anagrams(string_list);
	        
	        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> l1, List<String> l2) {
                    String s1 =  l1.get(0);
                    String s2 = l2.get(0);
                    
                    return s1.compareTo(s2);
                }
            });
	        
	        for(int i=0;i<ans.size();i++)
	        {
	            for(int j=0;j<ans.get(i).size();j++)
	            {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	       
	       
            t--;
	    }
	}
    
}
// } Driver Code Ends


//User function Template for Java

class Solution {
   
     public String sortString(String str) {
        char []arr = str.toCharArray();
        Arrays.sort(arr);
        //System.out.print(String.valueOf(arr));
        return String.valueOf(arr);
    }
    public List<List<String>> Anagrams(String[] nums) {
        List<List<String>>ans = new ArrayList<List<String>>(); 
        String arr[] = new String[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            String s = nums[i];
            arr[i] = sortString(s);
        }
        int visited[] = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            
            if(visited[i]!=1)
            {
                ArrayList<String>smallans = new ArrayList<>();
                smallans.add(nums[i]);
            for(int j=i+1;j<nums.length;j++)
            {
                if(arr[i].equals(arr[j]) && visited[j]!=1)
                {
                    smallans.add(nums[j]);
                    visited[j] = 1;
                }
            } 
                ans.add(smallans);
            }
            visited[i] = 1;
            
        }
        return ans;
        
    }
}
