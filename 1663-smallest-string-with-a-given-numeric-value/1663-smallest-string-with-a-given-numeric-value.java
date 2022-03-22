class Solution {
    public String getSmallestString(int n, int k) {
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            int pleft = (n - i - 1);
            if (k > pleft * 26) {
                int add = k - (pleft * 26);
                result[i] = (char) ('a' + add - 1);
                k -= add;
            } else {
                result[i] = 'a';
                k--;
            }
        }
        return new String(result);
    }
}