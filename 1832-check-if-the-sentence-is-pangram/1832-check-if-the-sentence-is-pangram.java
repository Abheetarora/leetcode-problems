class Solution {
    public boolean checkIfPangram(String sentence) {
        int arr[] = new int[26];
        for(int i=0;i<sentence.length();i++)
        {
            arr[sentence.charAt(i)-'a']++;
        }
        int flag = 0;
        for(int i=0;i<26;i++)
        {
            if(arr[i] == 0)
            {
                flag = 1;
            }
        }
        if(flag == 1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}