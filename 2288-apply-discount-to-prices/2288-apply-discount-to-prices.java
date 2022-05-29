class Solution {
 //    private static final DecimalFormat df = new DecimalFormat("0.00");
    public String discountPrices(String sentence, int discount) {
        
        String strs[] = sentence.split(" ");
        
        int n = strs.length;
        String str = "";
        for(int i=0;i<n;i++){
 
         if(check(strs[i])){
             
             int k = strs[i].length();
            double a=0;
             a= Double.parseDouble(strs[i].substring(1));
             // for(int j=1;j<k;j++){
             //    a=a*10 +  ((int)strs[i].charAt(j) -'0');
             // }
             
        
              String dec=String.format("%.2f",a*(100-discount)*1.0/100.0);
             dec="$"+dec;
             if(i==n-1){
                str = str+dec; 
             }else{
                 str = str+dec+" "; 
             }
            
         }else{
             
             if(i==n-1){
                 str = str+strs[i];
             }else{
               str = str+strs[i]+" ";
              }
         }
        }
       
        return str;
        
        
    }
    static boolean check(String str){
           
        int n = str.length();
        
        boolean flag =true;
        
        if(str.charAt(0) != '$'){
            flag =false;
            return flag;
            
        }else{
            for(int i=1;i<n;i++){
              if(((int)str.charAt(i)-'0') >=0  && ((int)str.charAt(i)-'0')<=9){
                   flag =true;
              }else{
                   flag =false;
                  break ;
              }
            }
            if(n==1){
                flag=false;
            }
            return flag;
        }
             
        
     }
}