package cn.sjtu.model.dp.lengthoflis_300_1005;

import java.util.Arrays;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-10-05 12:30
 * @description：最长递增子序列
 */

public class Solution {

    //定义dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度。
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        //初始化都为1
        Arrays.fill(dp,1);

        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[i] > nums[j]){
                    //求dp[i]之前最长的子序列，dp[i]取最长
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        //求dp中最大的值就是满足题目要求
        int result =1;
        for(int res:dp){
            result = Math.max(res,result);
        }
        return result;
    }

    // patience sorting（耐心排序）
    public int lengthOfLISWithBinarySearch(int[] nums) {
        int[] top  = new int[nums.length];
        //牌堆初始化为0
        int piles = 0;
        for(int i =0; i < nums.length;i++){
            // 要处理的扑克牌
            int poker = nums[i];

            /***** 搜索左侧边界的二分查找 *****/
            int left = 0;
            int right = piles;
            while(left < right){
                int mid = (left+right)/2;
                if(top[mid] > poker){
                    right = mid;
                }else if(top[mid] < poker) {
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }

            // 没找到合适的牌堆，新建一堆
            if(left == piles){
                piles++;
            }
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }


}
