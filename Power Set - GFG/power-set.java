// { Driver Code Starts
//Initial Template for Java

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
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        char [] ch = s.toCharArray();
        
        int n = ch.length;
        
        int tot = (1<<n)-1;
        ArrayList<String> res = new ArrayList<>();
        
        for(int i=1;i<=tot;i++){
            String rs = "";
            
            int b = i;
            int pos = 0;
            while(b>0){
                if((b%2 == 1))
                    rs+= Character.toString(ch[pos]);
                b= b/2;    
                pos++;
            }
            res.add(rs);
        }
        Collections.sort(res);
        return res;
    }
}