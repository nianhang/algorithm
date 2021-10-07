package cn.sjtu.model.string.findanagrams_438_0924;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-24 15:38
 * @description：找到字符串中所有字母异位词
 */

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "cbaebabacd";
        String s2 = "abc";
        solution.findAnagrams(s1,s2);

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();

        for(int i = 0; i<p.length();i++){
            char c = p.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left = 0,right = 0;
        int valid = 0;

        while(right < s.length()){

            char r = s.charAt(right);
            right ++;
            //查看是否符合要求的字符，符合要求的话，更新数据
            if(need.containsKey(r)){
                window.put(r,window.getOrDefault(r,0)+1);
                if(window.get(r).equals(need.get(r))){
                    valid ++;
                }
            }

            while(right - left >= p.length()){
                if(valid == need.size()){
                    res.add(left);
                }
                char l = s.charAt(left);
                left++;
                if(need.containsKey(l)){
                    if(window.get(l).equals(need.get(l))){
                        valid--;
                    }
                    window.put(l,window.get(l)-1);
                }
            }

        }
        return res;

    }

}
