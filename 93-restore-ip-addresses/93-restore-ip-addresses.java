class Solution {
    public List<String> restoreIpAddresses(String s) {
         List<String> ret = new LinkedList<>();
    int[] path = new int[4];
    solve(ret, s, path,0, 0);
    return ret;
    }
    public void solve(List<String>ans,String s,int []path,int segment,int index)
    {
       if(index == s.length() && segment == 4)
       {
           ans.add(path[0]+"." + path[1] + "." + path[2] + "." + path[3]);
           return;
       }
        if(index == s.length() || segment == 4)
        {
            return;
        }
        for(int i=1;i<=3 && i+index<=s.length();i++)
        {
          int val = Integer.parseInt(s.substring(index, index + i));
            if(val > 255 || i>=2 && s.charAt(index) == '0')
            break;
            path[segment] = val;
            solve(ans,s,path,segment+1,index+i);
        }  
    }
    
}