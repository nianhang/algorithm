package cn.sjtu.model.dp.longestcommonsubsequence_1143_1005;

import java.util.Arrays;

/**
 * @author ��linfd
 * @version :�е�$
 * @date ��Created in 2021-10-05 16:46
 * @description�������������
 */

public class Solution {

    //�Զ����µĶ�̬�滮
    //����¼�������ص�������
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // ����¼ֵΪ -1 ����δ������
        memo = new int[m][n];
        for(int[] row : memo){
            Arrays.fill(row,-1);
        }
        return dp(text1,0,text2,0);
    }

    //dp(s1,i,s2,j)��ʾs1[i...]��s2[j...]������������г���
    private int dp(String s1,int i,String s2,int j){
        //s1��s2��һ���ַ�������β��
        if(i == s1.length() || j == s2.length()){
            return 0;
        }
        // ���֮ǰ���������ֱ�ӷ��ر���¼�еĴ�
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        // ���� s1[i] �� s2[j] �Ƿ������ѡ��
        if(s1.charAt(i) == s2.charAt(j)){
            //s1[i]��s2[j]��Ȼ��lcs��
            memo[i][j] = 1+dp(s1,i+1,s2,j+1);
        }else {
            // s1[i] �� s2[j] ������һ������ lcs ��
            memo[i][j] = Math.max(
                    //s1[i]���� lcs ��
                    dp(s1,i+1,s2,j),
                    //s2[j]���� lcs ��
                    dp(s1,i,s2,j+1));
        }

        return memo[i][j];
    }

    //�Ե����ϵĶ�̬�滮
    public int longestCommonSubsequenceWithTopDown(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        // ���壺s1[0..i-1] �� s2[0..j-1] �� lcs ����Ϊ dp[i][j]
        // Ŀ�꣺s1[0..m-1] �� s2[0..n-1] �� lcs ���ȣ��� dp[m][n]
        // base case: dp[0][..] = dp[..][0] = 0

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                // ���� i �� j �� 1 ��ʼ������Ҫ��һ
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    // s1[i-1] �� s2[j-1] ��Ȼ�� lcs ��
                    dp[i][j] = 1+dp[i-1][j-1];
                }else {
                    // s1[i-1] �� s2[j-1] ������һ������ lcs ��
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }

        }
        return dp[m][n];
    }


}
