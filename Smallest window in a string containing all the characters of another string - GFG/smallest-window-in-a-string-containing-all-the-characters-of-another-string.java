// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        return ans(s,p);
    }
     public static String ans(String s, String t) {
        if (s.equals(t)) {
            return s;
        }
        if (s.length() == 0 || t.length() == 0) {
            return "-1";
        } 
        int nt = t.length();
        int ns = s.length();
        // collect char frequency map in t
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < nt; i++) {
            char c = t.charAt(i);
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }
        
        int diffChar = tmap.size(); // record the map size 
        int left = 0;
        int minLeft = 0; // for start of res
        int minLen = Integer.MAX_VALUE; // for len of res
        int count = 0; // number of covered char (which value in tmap is <= 0)
        
        for (int right = 0; right < ns; right++) {
            char rc = s.charAt(right);
            // continue if rc is not in t
            if (!tmap.containsKey(rc)) {
                continue;
            }
            tmap.put(rc, tmap.get(rc) - 1);
            // all occurances of a rc is in left,right
            if (tmap.get(rc) == 0) { 
                count++;
            }
            // since there might be duplicate chars in t, 
            // we need to compare with mapsize rather than t.length()
            while (count == diffChar) { 
                if (right - left + 1 < minLen) {
                    minLeft = left;
                    minLen = right - left + 1;
                }
                char lc = s.charAt(left);
                if (tmap.containsKey(lc)) {
                    tmap.put(lc, tmap.get(lc) + 1);
                    // only decrement the count when it just changed from 0 to 1
                    // it means one char is disappear from left to right;
                    if (tmap.get(lc) == 1) {
                        count--;
                    }
                }
                left++;
            }
        }
        if (minLen > s.length()) {
            return "-1";
        }
        return s.substring(minLeft, minLeft + minLen);
    }
}