package cn.sjtu.model.string.minwindow_76_0923;

import java.util.HashMap;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-23 23:06
 * @description：最小覆盖子串
 */

public class Solution {



    public String minWindow(String s, String t) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();

        for(int i = 0; i<t.length();i++){
            char c = t.charAt(i);
            need.put(c,need.getOrDefault(c,0) +1);
        }

        int left = 0 ,right = 0;
        int valid = 0;

        int start = 0,len = Integer.MAX_VALUE;

        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0) + 1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while(valid == need.size()){
                // 在这里更新最小覆盖子串
                if(right - left < len){
                    start = left;
                    len = right -left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }
        }
        // 返回最小覆盖子串

        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }


}
