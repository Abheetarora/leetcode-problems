class Solution {
   public int countCollisions(String directions) {
        
        int collisions = 0;
        Stack<Character> st = new Stack();
        st.push(directions.charAt(0));
        for(int i = 1;i<directions.length();i++){
            char curr = directions.charAt(i);
      
            if((st.peek()== 'R' && curr == 'L')  ){
                
                collisions+=2;
                st.pop();
                curr = 'S';
     

            }else if((st.peek() == 'S' && curr == 'L')){
                curr = 'S';
                collisions+=1;
            }
        
            while(!st.isEmpty() && ((st.peek() == 'R' && curr == 'S') )){
                collisions+=1;
              st.pop();
            }
            
            st.push(curr);
        }
        
        return collisions;
    }
}