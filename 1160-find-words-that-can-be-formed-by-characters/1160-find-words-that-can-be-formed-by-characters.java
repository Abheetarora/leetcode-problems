class Solution {
    public int countCharacters(String[] words, String chars) {
        int [] charscount=new int[26];
        for(int i=0; i<chars.length(); i++){
            charscount[chars.charAt(i)-'a']++;
        }
        
        int count=0;
        
        for(String word: words){
            if(check(word,charscount)==true){
                count+=word.length();
            }
        }
        
        return count;
        
    }
    
    public boolean check(String word, int [] freq){

        int [] check=new int[26];
        for(int i=0; i<word.length(); i++){
            check[word.charAt(i)-'a']++;
        }
        for(int i=0; i<word.length(); i++){
            if(freq[word.charAt(i)-'a']-check[word.charAt(i)-'a']<0){
                return false;
            }
        }
        
        return true;
    }
}