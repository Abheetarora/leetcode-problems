class Solution {
    public int removePalindromeSub(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String reversedString = sb.toString();
        if (reversedString.equals(s)) {
            return 1;
        }
        return 2;
    }
}