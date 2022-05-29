class Solution {
public boolean noCommonLetters(String s1, String s2){
  for (char ch : s1.toCharArray())
    if (s2.indexOf(ch) != -1) return false;
  return true;
}
  public int maxProduct(String[] words) {
    int n = words.length;

    int maxProd = 0;
    for (int i = 0; i < n; ++i)
      for (int j = i + 1; j < n; ++j)
        if (noCommonLetters(words[i], words[j]))
          maxProd = Math.max(maxProd, words[i].length() * words[j].length());

    return maxProd;
  }
}