package cn.sjtu.model.dp.lengthoflis_300_1005;

import java.util.Arrays;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-10-05 12:30
 * @description�������������
 */

public class Solution {

    //����dp[i] ��ʾ�� nums[i] �������β������������еĳ��ȡ�
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        //��ʼ����Ϊ1
        Arrays.fill(dp,1);

        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[i] > nums[j]){
                    //��dp[i]֮ǰ��������У�dp[i]ȡ�
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        //��dp������ֵ����������ĿҪ��
        int result =1;
        for(int res:dp){
            result = Math.max(res,result);
        }
        return result;
    }

    // patience sorting����������
    public int lengthOfLISWithBinarySearch(int[] nums) {
        int[] top  = new int[nums.length];
        //�ƶѳ�ʼ��Ϊ0
        int piles = 0;
        for(int i =0; i < nums.length;i++){
            // Ҫ������˿���
            int poker = nums[i];

            /***** �������߽�Ķ��ֲ��� *****/
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

            // û�ҵ����ʵ��ƶѣ��½�һ��
            if(left == piles){
                piles++;
            }
            // �������Ʒŵ��ƶѶ�
            top[left] = poker;
        }
        // �ƶ������� LIS ����
        return piles;
    }


}
