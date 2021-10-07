package cn.sjtu.model.array.removeelement_27_0926;

import java.util.Collections;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-26 23:15
 * @description：移除元素
 */

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2};
        int val = 3;
        System.out.println(solution.removeElement(nums,val));

    }

    //有问题
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1){
            if(nums[0]==val){
                return 0;
            }else {
                return 1;
            }
        }
        int last = nums.length-1;
        int i = 0;
       while(i< last){
            if(nums[i] == val){
                while(nums[last] == val && last > 0){
                    last--;
                }
                if(last ==0){
                    break;
                }
                int temp = nums[i];
                nums[i] = nums[last];
                nums[last] = temp;
                last --;
            }
            i++;
        }
       if(last <= 0){
           return 0;
       }
        return i;
    }


    public int removeElementWithFastSlow(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        while(fast < nums.length){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
