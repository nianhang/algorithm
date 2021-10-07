package cn.sjtu.model.array.movezeroes_283_0926;

/**
 * @author £∫linfd
 * @version :$
 * @date £∫Created in 2021-09-27 0:01
 * @description£∫“∆∂Ø¡„
 */

public class Solution {



    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(fast < nums.length){
            if(nums[fast] != 0){
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
    }


}
