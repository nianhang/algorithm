package cn.sjtu.model.array.twosum1_1_0907;

import java.util.HashMap;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-07 19:49
 * @description：
 */

public class Solution {

    /**
     * leetcode 第1题 两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                res[0] = i;
                int k = map.get(target - nums[i]);
                res[1] = k;
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }


}
