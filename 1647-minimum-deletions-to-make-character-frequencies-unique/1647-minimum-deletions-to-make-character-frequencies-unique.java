class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer>freq = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char p = s.charAt(i);
            int prev = 0;
            if (freq.get(p) != null) {
                prev = freq.get(p);
            }
            freq.put(p, prev + 1);
        }
        
        HashSet<Integer>s1=new HashSet<>();
        int ans =0;
        for (char key : freq.keySet()) 
        {
             int temp = freq.get(key);
            while(s1.contains(temp) && temp>=0)
                                {
                                    ans++;
                                    temp--;
                                }    
            if(temp>0)
            s1.add(temp);
            
        }
        System.out.println(s1);
        return ans;
    }
}