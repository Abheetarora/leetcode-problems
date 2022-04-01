class Solution {
    public void reverseString(char[] s) {
           int end = s.length-1,start =0;
        while (end > start){
          char temp =  s[end] ;
          s[end] = s[start] ;
          s[start] = temp ;
          start++;
          end--;
        }
    }
}