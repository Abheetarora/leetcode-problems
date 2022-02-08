// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				String str = br.readLine();
				Solution ob= new Solution();
				String str1 = ob. rearrangeCharacters(str);
				
        		int flag=1;
        	    int[] c = new int[26];
        	    Arrays.fill(c,0);
        	    for(int i=0; i<str.length(); i++)
        	        c[str.charAt(i)-'a']+=1;
        	    int f = 0;
        	    int x = (str.length()+1)/2;
        	    for(int i=0; i<26; i++)
        	    {
        	        if(c[i]>x)
        	            f = 1;
        	    }
        	    if(f == 1)
        	    {
        	        if(str1=="-1")
        	            System.out.println(0);
            	    else
            	        System.out.println(1);
        	    }
        	    else
        	    {
            	    int[] a = new int[26];
        	        Arrays.fill(a,0);
            	    int[] b = new int[26];
        	        Arrays.fill(b,0);
            	    for(int i=0; i<str.length(); i++)
            	        a[str.charAt(i)-'a']+=1;
            	    for(int i=0; i<str1.length(); i++)
            	        b[str1.charAt(i)-'a']+=1;
            	        
            	    for(int i=0; i<26; i++)
            	        if(a[i]!=b[i])
            	            flag = 0;
            	    
            	    for(int i=0;i<str1.length();i++)
            	    {
            		    if(i>0)
            		        if(str1.charAt(i-1)==str1.charAt(i))
            			        flag=0;
            	    }
            	    if(flag==1)
            		    System.out.println(1);
            	    else
            	        System.out.println(0);
        	    }
			}
		} catch (Exception e) {

		}
	}
}// } Driver Code Ends


class Solution
{
	public static String rearrangeCharacters(String s) {
	 int [] freq = new int[26]; //to Store Frequency of each alphabet
        char [] arr = s.toCharArray();
        
        for(int i = 0;i<arr.length;i++){  //store the frequency
            freq[arr[i] - 'a']++;
        }
        
        int max = 0,letter = 0;
        
        for(int i = 0;i<26;i++){  //find the max frequency
            if(freq[i] > max){
                max = freq[i];
                letter = i;
            }
        }
        
        if(max > (s.length() + 1)/2) return "-1"; //if max is more than half then not possible
        
        int idx = 0;
        char [] res = new char[s.length()];
        
        while(freq[letter] > 0){   //distribute the max freq char into even indices
            res[idx] = (char)(letter + 'a');
            idx += 2;
            freq[letter]--;
        }
        
        for(int i = 0;i<26;i++){  
            while(freq[i] > 0){
            if(idx >= s.length()) idx = 1; //all even indices filled, so switch to odd indices
            res[idx] = (char)(i + 'a');
            idx += 2;
            freq[i]--;
          }
            
        }
        
        return String.valueOf(res);  
		//code here
	}
}