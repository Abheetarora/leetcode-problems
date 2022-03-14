class Solution {
    public String simplifyPath(String path) {
        Stack<String>st = new Stack<String>();
        String[]arr = path.split("/");
        for(String dir : arr)
        {
            if(dir.equals(".") || dir.isEmpty())
            {
                continue;
            }
            else if(dir.equals(".."))
            {
                if(!st.isEmpty())
                {
                    st.pop();
                }
               
            }
             else
                {
                    st.add(dir);
                }
        }
        String ans = "";
        for(String i:st)
        {
            ans += "/";
            ans += i;
        }
        return ans.length()>0?ans:"/";
    }
}