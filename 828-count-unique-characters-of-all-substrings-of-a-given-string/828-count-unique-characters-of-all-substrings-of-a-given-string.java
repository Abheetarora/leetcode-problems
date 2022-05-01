class Solution {
     public int uniqueLetterString(String s) {
      int[] sum=new int[1];
      sum[0]=0;
      int size=s.length();  
      HashMap<Character,List<Integer>>tracker=new HashMap<>();  
       for(int i=0;i<size;i++){
            if(tracker.containsKey(s.charAt(i))){
             tracker.get(s.charAt(i)).add(i);
            }else{
                List<Integer>track=new ArrayList();
                track.add(i);
                tracker.put(s.charAt(i),track);
            }
       }
      tracker.entrySet().forEach(entry->{
          List<Integer> track=entry.getValue();
          int n=track.size();
          for(int i=0;i<n;i++){
               int left= i==0?track.get(i)+1:(track.get(i)-track.get(i-1));
               int right=i==n-1?size-track.get(i):(track.get(i+1)-track.get(i));
              sum[0]=sum[0]+(left*right);
          }
      });  
       
        return sum[0];
         
     }
}