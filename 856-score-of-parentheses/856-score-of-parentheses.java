class Solution {
    public int scoreOfParentheses(String str) {
       Stack<Integer> s=new Stack<>();
        s.push(0);
        for(char ch:str.toCharArray()){
            if(ch=='('){
                s.push(0);
            }else{
                int v=s.pop();
                int w=s.pop();
                s.push(w+Math.max(2*v,1));
            }
        }
        return s.pop();
    }
}