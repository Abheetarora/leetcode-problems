class Solution {
    public int addDigits(int num) {
        int temp = num;
        int p = 0;
        while(num > 9)
        {
           p = p + temp%10;
            temp = temp/10;
            if(temp == 0 && p>0)
            {
                num = p;
                temp = num;
                p=0;
            }
            System.out.println(num);
        }
        return num;
    }
}