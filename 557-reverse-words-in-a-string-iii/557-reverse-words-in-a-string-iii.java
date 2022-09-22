class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ", -2);
        for(int i=0;i<arr.length;i++)
        {
           
       StringBuilder reverseString = new StringBuilder(arr[i]);
       reverseString.reverse();  
       arr[i] = reverseString.toString();
           // System.out.println(arr[i]);
           //arr[i] = reverse(arr[i]);
        }
        String ans = "";
        for(int i=0;i<arr.length;i++)
        {
            if(i!=arr.length-1)
            {
                ans+=arr[i]+" ";
            }
            else
            {
                ans+=arr[i];
            }
        }
        return ans;
    }
}