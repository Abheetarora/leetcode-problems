class Solution {
    class Span{
        int ct;
        int height;
        Span(int ct, int height){
            this.ct = ct;
            this.height = height;
        }
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Span> stackL = new Stack<>();
        Stack<Span> stackR = new Stack<>();
        int [] listL = new int[heights.length+1];
        int [] listR = new int[heights.length+1];

        int ans=0;
        int ct = 0;
        
        for(int i = 0;i<heights.length;i++)
        {
            ct = 1;
           while(!stackL.empty() && stackL.peek().height>=heights[i]){
               ct = ct + stackL.pop().ct;
           }
            listL[i]=ct;
            stackL.push(new Span(ct,heights[i]));
            
            ct = 1;
            while(!stackR.empty()&&stackR.peek().height>=heights[heights.length-i-1]){
               ct = ct + stackR.pop().ct;
           }
            listR[heights.length-i-1]=ct;
            stackR.push(new Span(ct,heights[heights.length-i-1]));
        }
        int area=0;
        for(int i =0;i<heights.length;i++){
            area = heights[i]*(listL[i]+listR[i]-1);
            if(area>ans){
                ans = area;
            }
        }
        return ans;
    }
}