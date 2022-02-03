class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        Arrays.sort(strs);
        String f=strs[0];
        String l=strs[strs.length-1];
        int c=0;
        while(c<f.length()){
            if(f.charAt(c)==l.charAt(c)){
                c++;
            }else{
                 break;
            }
        }
        if(c==0){
            return "";
        }else{
            return f.substring(0,c);
        }
        
        
    }
}