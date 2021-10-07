package cn.sjtu.model.string.lengthoflongestsubstring_3_0924;


import java.util.HashMap;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-24 16:18
 * @description：无重复字符的最长子串
 */

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        HashMap<Character,Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int max = 0;
        while(right < s.length()){

            char c = s.charAt(right);
            right++;

            window.put(c,window.getOrDefault(c,0)+1);
            //窗口中有重复数据就得移动left指针
            while(window.get(c) > 1){
               char d = s.charAt(left);
               left++;
               window.put(d,window.get(d)-1);
            }
            //收缩窗口后数据一定没有重复的
            max = Math.max(max,right -left);
        }
        return max;
    }

}
