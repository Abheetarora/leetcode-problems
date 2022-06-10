class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1){
            return s.length();
        }

        int[] arr = new int[s.length()];
		int i = 0;
        int flag=0;
        int max=-1;
		while( i < s.length() ) {
			StringBuilder str = new StringBuilder();
			for(int j=i; j <=s.length()-1; j++){
				if((str.toString().contains(s.charAt(j)+""))) {
                    max=Math.max(max,str.length());
					break;
				}
				str.append(s.charAt(j));
                if(j==s.length()-1)
                 {
                   
                     max=Math.max(max,str.length());
                   flag=1;
                    break;
                 }
			}
            if(flag==1)
            {
                break;
            }
			
			i++;
		}
		return max;
    }
}