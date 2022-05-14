class Solution {
public List<List<Integer>> subsets(int[] nums) {

    List<List<Integer>> ans = new ArrayList<>();
    
    ans.add(new ArrayList<>());
    generateCombination(ans, new ArrayList(), nums, 0);
    return ans;
    
}

public void generateCombination(List<List<Integer>> ans, List<Integer> tmp, int[] nums, int index){
    
    if(index==nums.length){
        return;
    }
    
   for(int i=index; i<nums.length; i++){
       tmp.add(nums[i]);
       ans.add(new ArrayList<>(tmp));
       generateCombination(ans, tmp, nums, i+1);
       tmp.remove(tmp.size()-1);
   }
    
}
}