class Solution {
    public String convertToTitle(int columnNumber) {
        columnNumber--;
        StringBuilder ans = new StringBuilder();
        while (columnNumber >= 0) {
            char temp = (char)(columnNumber % 26 + 65);
            ans.append(temp);
            columnNumber /= 26;
            columnNumber--;
        }
        return ans.reverse().toString();
    }
}