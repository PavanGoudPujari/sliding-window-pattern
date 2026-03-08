//Problem Statement
//s="ADOBECODEBANC"
//t = "ABC"
// output : "BANC"

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t){
        if(s== null || t==null|| s.length() == 0 ||t.length()==0) return"";
        Map<Character, Integer> need = new HashMap<>();
        for(char ch : t.toCharArray()){
            need.put(ch, need.getOrDefault(ch,0)+1);
        }
        Map<Character, Integer>window = new HashMap<>();
        int left =0;
        int formed = 0;
        int required = need.size();

        int minLen = Integer.MAX_VALUE;
        int start= 0;

        for (int right =0; right<s.length(); right++){
            char c =s.charAt(right);
            window.put(c,window.getOrDefault(c,0)+1);

            if(need.containsKey(c) && window.get(c).equals(need.get(c))){
                formed++;
            }

            while(formed == required){
                int windowLen = right-left+1;
                if(windowLen < minLen){
                    minLen= windowLen;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar)-1);

                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }
                left++;
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start, start+minLen);
    }
    public static void main(String[] args){
        String s="ADOBECODEBANC";
        String t= "ABC";
        System.out.println(minWindow(s,t)); // output:BANC
    }
}
