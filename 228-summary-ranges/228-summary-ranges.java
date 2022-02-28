class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String>arr = new ArrayList<>();
        
        int i = 0;
        while(i!=nums.length)
        {
          String s ="";
            s+=nums[i];
            int flag = 0;
            while( (i+1) != nums.length && (nums[i+1] - nums[i] == 1) )
            {
                flag =1;
                i++;
            }
            if(flag == 1)
            {
                s+="->";
                    s+=nums[i];
                arr.add(s);
                flag = 0;
                i++;
            }
            else
            {
                arr.add(s);
                i++;
            }
        }
        return arr;
    }
}