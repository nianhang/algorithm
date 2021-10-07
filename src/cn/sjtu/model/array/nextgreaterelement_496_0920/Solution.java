package cn.sjtu.model.array.nextgreaterelement_496_0920;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-20 12:42
 * @description����һ������Ԫ�� I
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
        //����ջ
        Stack<Integer> stack = new Stack<Integer>();
        //�ŵ�map�п��Բ鿴
        HashMap<Integer,Integer> resultMap = new HashMap<>(nums2length);

        /*for(int i = 0;i<nums2length;i++){
            //ջ��ջ����ջ���Ǵ�С���󣬼�����ջ
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
