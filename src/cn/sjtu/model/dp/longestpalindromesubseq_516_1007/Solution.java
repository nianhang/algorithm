package cn.sjtu.model.dp.longestpalindromesubseq_516_1007;

import java.util.Arrays;

/**
 * @author ��linfd
 * @version :�е�$
 * @date ��Created in 2021-10-07 12:14
 * @description�������������
 */

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String test = "bbbab";

        System.out.println(solution.longestPalindromeSubseq(test));

    }


    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        //���Ӵ�s[i..j]�У�����������еĳ���Ϊdp[i][j]
        int[][] dp = new int[n][n];
        //ȫ����ʼ��Ϊ0
        /*for(int[] row : dp){
            Arrays.fill(row,0);
        }*/
        // base case
        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }

        for(int i = n-1;i >= 0;i--){
            for (int j = i+1; j<n; j++){
                // ״̬ת�Ʒ���
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        // ���� s ��������Ӵ�����
        return dp[0][n-1];
    }


}
