package cn.sjtu.model.array.maxslidingwindow_239_0921;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-21 23:42
 * @description�������������ֵ
 */

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();



        for(int i =0 ;i < nums.length;i++){
            if(i < k-1){
                //���ڴ���������k-1��Ԫ�أ��������У���ͷ�󣬶�βС
                window.push(nums[i]);
            }else {
                //���������
                window.push(nums[i]);
                //��¼��ǰ���ڵ����ֵ
                res.add(window.max());
                //�Ƴ�������
                window.pop(nums[i - k +1]);
            }
        }
        int[] arr = new int[res.size()];

        for(int i = 0 ;i< res.size();i++){
            arr[i] = res.get(i);
        }
        return arr;
    }

}
