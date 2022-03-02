class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0)
            return true;
        int i=0;//s pointer
        int j=0;//t pointer
        while(j<t.length())
        {
            if(t.charAt(j)==s.charAt(i))
            {
                i++;
                if(i==s.length())
                    return true;
            }
            j++;
        }
        return false;
    }
}