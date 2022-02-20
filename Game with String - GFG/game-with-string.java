// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        Map <Character ,Integer> map = new HashMap <Character ,Integer> ();
        for(int i = 0 ; i < s.length() ; i++){
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i) , 0) + 1);
        }
        PriorityQueue <Integer> queue = new PriorityQueue <Integer> (Collections.reverseOrder());
        for(int v : map.values()){
            queue.add(v);
        }
        
        while(k!=0){
            int poll = queue.poll();
            queue.add(poll-1);
            k--;
        }
        
        int sum = 0;
        while(!queue.isEmpty()){
            int poll = queue.poll();
            sum += poll*poll;
        }
        return sum;
    }
}