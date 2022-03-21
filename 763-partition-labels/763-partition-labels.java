class Solution {
      public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int start = 0;
        int len = s.length();
        while (start < len) {
            //the longest index of this range
            int tmpMax = 0;
            int end = lastIndex[s.charAt(start) - 'a'];
            for (int i = start; i <= end; i++) {
                tmpMax = Math.max(tmpMax, lastIndex[s.charAt(i) - 'a']);
                if (lastIndex[s.charAt(i) - 'a'] > end) {
                    //extend end based on inteval character's last Index
                    end = lastIndex[s.charAt(i) - 'a'];
                }
            }
			// calculate lenght of each part
            res.add(tmpMax - start + 1);
            start = tmpMax + 1;
        }
        return res;
    }
}