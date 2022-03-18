class Solution {
   public String removeDuplicateLetters(String s) {
    StringBuilder sb= new StringBuilder();
    int[] charFreq= new int[26];
    boolean[] used= new boolean[26];
    for(int i=0; i<s.length(); i++) charFreq[s.charAt(i)-'a']++;
    for(int i=0; i<s.length(); i++){
        int c= s.charAt(i)-'a';
        charFreq[c]--;
        if(used[c]) continue;
        used[c]= true;
        while(sb.length()>0 && sb.charAt(sb.length()-1)>s.charAt(i) &&
              charFreq[sb.charAt(sb.length()-1)-'a']>0){
            char f= sb.charAt(sb.length()-1);
            sb.setLength(sb.length()-1);
            used[f-'a']= false;
        }
        sb.append(s.charAt(i));
    }
    return String.valueOf(sb);
}
}