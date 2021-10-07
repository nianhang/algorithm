package cn.sjtu.model.array.twosum2_167_0927;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-27 21:35
 * @description：两数之和 II - 输入有序数组
 */

public class Solution {


    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];

        int first = 0;
        int last = numbers.length -1;

        while(first < last){
            int sum = numbers[first] + numbers[last];
            if( sum == target){
                res[0] = first;
                res[1] = last;
                return res;
            }else if(sum > target){
                last--;
            }else if (sum < target){
                first ++;
            }

        }
        return res;
    }

}
