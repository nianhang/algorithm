package cn.sjtu.model.dp.maxdubarray_53_1005;

/**
 * @author ��linfd
 * @version :��$
 * @date ��Created in 2021-10-05 16:19
 * @description����������
 */

public class Solution {

    //��nums[i]Ϊ��β�ġ����������͡�Ϊdp[i]��
    public int maxSubArray(int[] nums) {
      int n = nums.length;
      if(n == 0){
          return 0;
      }
      int[] dp = new int[n];
      // base case ��һ��Ԫ��ǰ��û��������
      dp[0] = nums[0];
      //״̬ת�Ʒ��̣�dp[i]Ҫô��dp[i-1]��nums[i]�ĺͣ�Ҫô��nums[i]�Գɵ�����
      for(int i = 1;i<n;i++){
          dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
      }
      //��dp[i]�е����ֵ
      int result = Integer.MIN_VALUE;
      for(int i=0; i<n; i++){
          result = Math.max(result,dp[i]);
      }
      return result;
    }

}
