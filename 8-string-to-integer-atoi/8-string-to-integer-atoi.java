class Solution {

public int myAtoi(String str) {
    long x=0;
    boolean fn=false; 
    int i=0;
    
    while(i<str.length()&&str.charAt(i)==' ') i+=1;
    
    if(i<str.length()&&str.charAt(i)=='-') {
        fn=true;
        i+=1;
    }
    
    if(i<str.length()&&str.charAt(i)=='+'&&!fn) i+=1;
    while(i<str.length()) {
        char c=str.charAt(i);
        if(c>='0'&&c<='9'&&x<=Integer.MAX_VALUE) {
                x=x*10+(c-'0');
            }
        else break;
          i+=1;  
    }
    if(fn) {
        x=-x;
        if(x<Integer.MIN_VALUE) return Integer.MIN_VALUE;
       }
    if(x>Integer.MAX_VALUE) return Integer.MAX_VALUE;
   
return (int)x;    
}
}

                            