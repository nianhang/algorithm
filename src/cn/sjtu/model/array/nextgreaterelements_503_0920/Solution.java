package cn.sjtu.model.array.nextgreaterelements_503_0920;

import java.util.Stack;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-21 23:22
 * @description：下一个更大元素 II
 */

public class Solution {

    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i= 2*n -1;i >= 0;i--){
            while (!stack.isEmpty() && stack.peek() <= nums[i%n]){
                stack.pop();
            }
            result[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i%n]);
        }

        return result;
    }

}
