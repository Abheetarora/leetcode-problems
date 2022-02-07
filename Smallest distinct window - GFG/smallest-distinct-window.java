// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str).length());
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public String findSubString( String str) {
        int len = str.length();
        int start = 0;int end =0;
        String ans = "";
        if(len<=1)
        {
            return str;
        }
        HashSet<Character>unique = new HashSet<>();
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            unique.add(ch);
        }
        int i=-1;
        int j=-1;
        HashMap<Character,Integer>map = new HashMap<>();
        while(true)
        {
            boolean f1 = false;
            boolean f2 = false;
            while(i<str.length()-1 && map.size() < unique.size())
            {
             i++;
             char ch = str.charAt(i);
             map.put(ch,map.getOrDefault(ch,0)+1);
             f1 = true;
            }
            
            while(j<i && map.size() == unique.size())
            {
                int pans = i-j;
                if(pans<=len)
                {
                    len = pans;
                    start = j;
                    end = j+len;
                   //System.out.println(len);
                  // ans = str.substring(j,i+1);
                }
                j++;
                char ch = str.charAt(j);
                if(map.get(ch) == 1)
                {
                    map.remove(ch);
                }
                else
                {
                    map.put(ch,map.get(ch)-1);
                }
                f2 = true;
            }
            if(f1 == false && f2 == false)
            {
                break;
            }
        }
        //System.out.println(start + " " +end);
       if(start == -1 || end == -1)
       {
          start++;
          end++;
       }
       
       
        return str.substring(start,end);
    }
}