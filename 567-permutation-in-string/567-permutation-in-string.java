class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
        {
            return false;
        }
       int arr[] = new int[26];
        for(int i=0;i<s1.length();i++)
        {
            arr[s1.charAt(i)-'a']++;
        }
        int prr[] = new int[26];
        for(int i=0;i<s1.length();i++)
        {
            prr[s2.charAt(i)-'a']++;
        }
           for(int i=0;i<=s2.length()-s1.length();i++)
           {
               int last = i + s1.length();
               System.out.println(i + " " + last);
               if(Arrays.equals(arr,prr))
               {
                   return true;
               }
               prr[s2.charAt(i)-'a']--;
               if(last < s2.length())
               prr[s2.charAt(last)-'a']++;
           }
        return false;
    }
}