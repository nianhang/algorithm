package cn.sjtu.model.string.checkinclusion_567_0923;

import java.util.HashMap;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-23 23:07
 * @description���ַ���������
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
            // ���д��������ݵ�һϵ�и���
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0) + 1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            // �ж���ര���Ƿ�Ҫ����
            while(right - left >= s1.length()){
                // �������ж��Ƿ��ҵ��˺Ϸ����Ӵ�
                if(valid == need.size()){
                    return true;
                }
                // d �ǽ��Ƴ����ڵ��ַ�
                char d = s2.charAt(left);
                // ���ƴ���
                left++;
                // ���д��������ݵ�һϵ�и���
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    Integer integer = window.get(d);
                    window.put(d,--integer);
                }
            }
        }
        // δ�ҵ������������Ӵ�
        return false;

    }


}
