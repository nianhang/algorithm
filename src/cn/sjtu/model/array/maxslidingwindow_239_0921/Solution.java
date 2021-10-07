package cn.sjtu.model.array.maxslidingwindow_239_0921;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-21 23:42
 * @description：滑动窗口最大值
 */

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();



        for(int i =0 ;i < nums.length;i++){
            if(i < k-1){
                //先在窗口中填上k-1个元素，单调队列，队头大，队尾小
                window.push(nums[i]);
            }else {
                //添加新数据
                window.push(nums[i]);
                //记录当前窗口的最大值
                res.add(window.max());
                //移出旧数字
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
