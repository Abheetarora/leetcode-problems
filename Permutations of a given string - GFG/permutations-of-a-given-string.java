// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}

// } Driver Code Ends


class Solution {
    List<String> arr = new ArrayList<>();
    public List<String> find_permutation(String s) {
        ans(s,"");
        Collections.sort(arr);
        return arr;
        
    }
    public void ans(String s , String output)
    {
        if(s.length() == 0)
        {
            arr.add(output);
            
        }
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            String p = s.substring(0,i) + s.substring(i+1);
            ans(p,output + ch);
        }
    }

}