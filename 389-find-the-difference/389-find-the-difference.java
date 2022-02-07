class Solution {
    public char findTheDifference(String th, String sh) {
        char ans='a';
        char[] sortedS = sh.toCharArray();
        char[] sortedT = th.toCharArray();
        Arrays.sort(sortedS);
        Arrays.sort(sortedT);
        String s = new String(sortedS);  
        String t = new String(sortedT);  
        // s = sortedS.toString();
        // t = sortedT.toString();
        if(s.substring(1)==t)
        {
            return s.charAt(0);
        }
    
        // System.out.println(s.substring(0,s.length()-1));
        // System.out.println(t);
        if(s.substring(0,s.length()-1).equals(t))
        {
            return s.charAt(s.length()-1);
        }
        for(int i=1;i<s.length();i++)
        {
            String temp = s.substring(0,i) + s.substring(i+1,s.length());
            // System.out.println(temp);
            // System.out.println(t);
            if(temp.equals(t))
            {
                return s.charAt(i);
            }
        }
        
        return ans;
    }
}