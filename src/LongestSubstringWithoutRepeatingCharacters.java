// Problem:
// Longest substring
// without repeating characters
//
// Example:
// "abcabcbb"
//
// Windows:
// "abc" -> length 3  ✔
// "bca" -> length 3
// "cab" -> length 3

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

public static int lengthOfLongestSubstring(String s){
    if(s==null || s.isEmpty()) return 0;
    Map<Character, Integer>lastSeen = new HashMap<>();
    int left =0;
    int maxLen=0;
    for(int right=0 ; right<s.length(); right++){
        char c= s.charAt(right);
        if(lastSeen.containsKey(c)){
            left=Math.max(left, lastSeen.get(c)+1);
        }
        lastSeen.put(c,right);
        maxLen =Math.max(maxLen, right-left+1);
    }
    return maxLen;
}
  public static void main(String[] args){
      System.out.println(lengthOfLongestSubstring("abcabcbb"));
  }
}
