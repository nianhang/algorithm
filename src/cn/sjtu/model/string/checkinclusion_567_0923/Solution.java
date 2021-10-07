package cn.sjtu.model.string.checkinclusion_567_0923;

import java.util.HashMap;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-23 23:07
 * @description：字符串的排列
 */

public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();

        for(int i = 0; i< s1.length();i++){
            char c = s1.charAt(i);
            need.put(c,need.getOrDefault(c,0) +1);
        }

        int left = 0 ,right = 0;
        int valid = 0;

        while(right < s2.length()){
            char c = s2.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0) + 1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while(right - left >= s1.length()){
                // 在这里判断是否找到了合法的子串
                if(valid == need.size()){
                    return true;
                }
                // d 是将移出窗口的字符
                char d = s2.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    Integer integer = window.get(d);
                    window.put(d,--integer);
                }
            }
        }
        // 未找到符合条件的子串
        return false;

    }


}
