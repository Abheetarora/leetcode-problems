class Solution {
public:
    vector<int> canSeePersonsCount(vector<int>& heights) {
        
        
        vector<int> ans(heights.size(),0);
        stack<int> st;
        st.push(heights[heights.size()-1]);
        
        for(int i=heights.size()-2; i>=0; i--){
            int count=0;
                
            while(st.size()!=0 && st.top()<heights[i]){
                count++;
                st.pop();
            }
                
            
            if(st.size()!=0 && st.top()>heights[i]){
                ans[i] = count+1;
            }
            
            else{
                ans[i] = count;
            }
            st.push(heights[i]);
        }
        
        return ans;
    }
};