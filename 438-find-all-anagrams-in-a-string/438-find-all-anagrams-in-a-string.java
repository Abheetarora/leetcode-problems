class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sarr[] = new int[26];
        int parr[] = new int[26];
         int ns = s.length(), np = p.length();
    if (ns < np) return new ArrayList();
         List<Integer> output = new ArrayList();
        for(int i=0;i<p.length();i++)
        {
            parr[p.charAt(i) -'a']++;
        }
        for(int i=0;i<p.length();i++)
        {
            sarr[s.charAt(i) - 'a']++;
        }
        for(int i=0;i<=s.length() - p.length();i++)
        {
            System.out.println(i);
            if(Arrays.equals(sarr,parr))
            {
                output.add(i);
            }
            sarr[(int)(s.charAt(i) - 'a')]--;
            if( i + p.length() < s.length() )
            sarr[(int)(s.charAt(i + (p.length())) - 'a')]++;
        }
        return output;
    }
}