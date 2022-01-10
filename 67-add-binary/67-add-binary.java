class Solution {
    public String addBinary(String a, String b) {
        int str1=a.length();
        int str2=b.length();
        int sum=0,carry=0;
        StringBuilder str=new StringBuilder();
        str1--;
        str2--;
        
        while(str1>=0 || str2>=0)
        {
            sum=0;
            if(str1>=0)
            {
                sum+=a.charAt(str1)-'0';
                str1=str1-1;
            }
            if(str2>=0)
            {
                sum+=b.charAt(str2)-'0';
                str2=str2-1;
            }
            sum=sum+carry;
            str.append(sum%2);
            carry=sum/2;
        }
        if(carry>0)
        {
            str.append(carry);
            
        }
        str=str.reverse();
        return str.toString();
    }
}