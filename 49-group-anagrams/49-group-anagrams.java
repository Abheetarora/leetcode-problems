class Solution {
    public String sortString(String str) {
        char []arr = str.toCharArray();
        Arrays.sort(arr);
        //System.out.print(String.valueOf(arr));
        return String.valueOf(arr);
    }
    public List<List<String>> groupAnagrams(String[] nums) {
        List<List<String>>ans = new ArrayList<List<String>>(); 
        String arr[] = new String[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            String s = nums[i];
            arr[i] = sortString(s);
        }
        int visited[] = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            
            if(visited[i]!=1)
            {
                ArrayList<String>smallans = new ArrayList<>();
                smallans.add(nums[i]);
            for(int j=i+1;j<nums.length;j++)
            {
                if(arr[i].equals(arr[j]) && visited[j]!=1)
                {
                    smallans.add(nums[j]);
                    visited[j] = 1;
                }
            } 
                ans.add(smallans);
            }
            visited[i] = 1;
            
        }
        return ans;
        
    }
}