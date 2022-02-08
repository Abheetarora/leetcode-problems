class Solution 
{
    public String removeDuplicates(String s) 
    {
        int i , length ;
        char value ;
        StringBuilder sb = new StringBuilder() ; 
        for( i = 0 ; i < s.length() ; i++ )
        {
            value = s.charAt(i) ;
            length = sb.length() ;
            if( length != 0 )
            {
                if( value == sb.charAt( length - 1 ) )
                {
                    sb.deleteCharAt( length - 1 ) ;
                }
                else
                {
                    sb.append(value) ;
                }
            }
            else
            {
                sb.append(value) ;
            }
        }
        return sb.toString() ;
    }
}
