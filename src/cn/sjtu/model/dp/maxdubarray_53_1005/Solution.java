package cn.sjtu.model.dp.maxdubarray_53_1005;

/**
 * @author ：linfd
 * @version :简单$
 * @date ：Created in 2021-10-05 16:19
 * @description：最大子序和
 */

public class Solution {

    //以nums[i]为结尾的「最大子数组和」为dp[i]。
    public int maxSubArray(int[] nums) {
      int n = nums.length;
      if(n == 0){
          return 0;
      }
      int[] dp = new int[n];
      // base case 第一个元素前面没有子数组
      dp[0] = nums[0];
      //状态转移方程，dp[i]要么是dp[i-1]和nums[i]的和，要么是nums[i]自成的序列
      for(int i = 1;i<n;i++){
          dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
      }
      //求dp[i]中的最大值
      int result = Integer.MIN_VALUE;
      for(int i=0; i<n; i++){
          result = Math.max(result,dp[i]);
      }
      return result;
    }

}
