package cn.sjtu.model.array.nextgreaterelement_496_0920;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-20 12:42
 * @description：下一个更大元素 I
 */

public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        Solution solution = new Solution();
        int[] ints = solution.nextGreaterElement(nums1, nums2);
        for(int res:ints){
            System.out.println(res);
        }
    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int nums1length = nums1.length;
        int nums2length = nums2.length;

        int[] result = new int[nums1length];
        //单调栈
        Stack<Integer> stack = new Stack<Integer>();
        //放到map中可以查看
        HashMap<Integer,Integer> resultMap = new HashMap<>(nums2length);

        /*for(int i = 0;i<nums2length;i++){
            //栈从栈顶到栈底是从小到大，即单调栈
            while (!stack.isEmpty() && stack.peek() < nums2[i]){
                resultMap.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }*/

        for(int i = nums2length -1;i >=0;i--){

            while(!stack.isEmpty() && stack.peek() <= nums2[i]){
                stack.pop();
            }
            resultMap.put(nums2[i],stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }


        for(int i = 0;i< nums1length;i++){
            result[i] = resultMap.getOrDefault(nums1[i],-1);
        }
        return result;
    }

}
