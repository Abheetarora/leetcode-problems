class Solution {
  public List<Integer> findAnagrams(String s, String p) {

    if (s.length() < p.length())
        return new ArrayList();

    Map<Character, Integer> map1 = new HashMap();
    Map<Character, Integer> map2 = new HashMap();
    for (char ch : p.toCharArray()) {
      if (map1.containsKey(ch)) {
        map1.put(ch, map1.get(ch) + 1);
      }
      else {
        map1.put(ch, 1);
      }
    }

    List<Integer> ans = new ArrayList();
    for (int i = 0; i < s.length(); ++i) {
      char ch = s.charAt(i);
      if (map2.containsKey(ch)) {
        map2.put(ch, map2.get(ch) + 1);
      }
      else {
        map2.put(ch, 1);
      }
      if (i >= p.length()) {
        ch = s.charAt(i - p.length());
        if (map2.get(ch) == 1) {
          map2.remove(ch);
        }
        else {
          map2.put(ch, map2.get(ch) - 1);
        }
      }
 
      if (map1.equals(map2)) {
        ans.add(i - p.length() + 1);
      }
    }
    return ans;
  }
}