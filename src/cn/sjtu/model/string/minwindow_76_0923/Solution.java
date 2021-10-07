package cn.sjtu.model.string.minwindow_76_0923;

import java.util.HashMap;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-23 23:06
 * @description����С�����Ӵ�
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
            // ���д��������ݵ�һϵ�и���
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0) + 1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            // �ж���ര���Ƿ�Ҫ����
            while(valid == need.size()){
                // �����������С�����Ӵ�
                if(right - left < len){
                    start = left;
                    len = right -left;
                }
                // d �ǽ��Ƴ����ڵ��ַ�
                char d = s.charAt(left);
                // ���ƴ���
                left++;
                // ���д��������ݵ�һϵ�и���
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }
        }
        // ������С�����Ӵ�

        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }


}
