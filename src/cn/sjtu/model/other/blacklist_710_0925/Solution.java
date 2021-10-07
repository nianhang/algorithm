package cn.sjtu.model.other.blacklist_710_0925;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-25 10:28
 * @description���������е������
 */

public class Solution {

    int selectSize;
    //���ں�������ӳ�䵽�����ں�������λ�ã�
    Map<Integer,Integer> mapping;
    public Solution(int n, int[] blacklist) {
        selectSize = n - blacklist.length;
        mapping = new HashMap<>();

        for(int bNum : blacklist){
            mapping.put(bNum,Integer.MAX_VALUE);
        }
        int last = n - 1;
        for(int changeNum : blacklist){
            //����changeNum������ѡ��λ�ã����Բ����ı䣬Ҳ����ѡ��
            if(changeNum >= selectSize){
                mapping.put(changeNum,changeNum);
                continue;
            }
            //β�����������ں�������
            while (mapping.containsKey(last)){
                last--;
            }

            mapping.put(changeNum,last);
            last--;
        }
    }

    // ������ [0,N) �еȸ������ѡȡһ��Ԫ�ز�����
    // ���Ԫ�ز����� blacklist �е�Ԫ��
    public int pick() {
        int index = (int)(Math.random()*selectSize);

        //����blackList����ȥӳ����Ѱ��
        if(mapping.containsKey(index)){
            return mapping.get(index);
        }
        //û�����еĻ���ֱ�ӷ���
        return index;
    }


}
