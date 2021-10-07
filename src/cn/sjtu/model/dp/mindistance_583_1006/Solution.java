package cn.sjtu.model.dp.mindistance_583_1006;

/**
 * @author ��linfd
 * @version :�е�$
 * @date ��Created in 2021-10-07 0:58
 * @description�������ַ�����ɾ������
 */

public class Solution {

    //ɾ���Ľ�����������������������
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // ����ǰ�ļ��� lcs ���ȵĺ���
        int lcs = longestCommonSubsequence(word1,word2);
        return m - lcs + n -lcs;

    }

    //�Ե����ϵĶ�̬�滮
    public int longestCommonSubsequence(String text1, String text2) {
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
