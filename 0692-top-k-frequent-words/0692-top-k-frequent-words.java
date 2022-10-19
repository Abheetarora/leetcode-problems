class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer>mp = new HashMap<>();
        for(int i=0;i<words.length;i++)
        {
            if(mp.get(words[i])==null)
            {
                mp.put(words[i],1);
            }
            else
            {
                int temp = mp.get(words[i]);
                mp.put(words[i],temp+1);
            }
        }
          List<String> candidates = new ArrayList<>(mp.keySet());
        Collections.sort(candidates,
                (w1, w2) -> mp.get(w1).equals(mp.get(w2)) ? w1.compareTo(w2) : mp.get(w2) - mp.get(w1));
        return candidates.subList(0, k);
    }
        
    }
