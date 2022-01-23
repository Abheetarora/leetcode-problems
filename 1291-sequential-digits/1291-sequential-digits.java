class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        List<Integer> item = new ArrayList<>();
        
        for (int len = 2; len <= digits.length(); len++) {
            for (int j = 0; j + len <= digits.length(); j++) {
                String sub = digits.substring(j, j + len);
                Integer num = Integer.parseInt(sub);
                if (num >= low && num <= high) {
                    item.add(num);
                }
            }
        }
        
        return item;
        
        
    }
}