package cn.sjtu.model.dp.mindistance_72_1004;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-10-04 18:20
 * @description���༭����
 */

public class Solution {

    /**
     * DP table ���Ե��������
     * ����dp[i][j] ���� word1 �� i λ��ת���� word2 �� j λ����Ҫ���ٲ���
     *
     * �� word1[i] == word2[j]��dp[i][j] = dp[i-1][j-1]��
     * �� word1[i] != word2[j]��dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
     * ���У�dp[i-1][j-1] ��ʾ�滻������dp[i-1][j] ��ʾɾ��������dp[i][j-1] ��ʾ���������
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];

        // ��Ҫ���� word1 �� word2 һ����ĸ��û�У�
        // ��ȫ����/ɾ�������������Ԥ�� dp[0][j] �� dp[i][0]
        for(int i = 1;i<=m;i++){
            dp[i][0] = i;
        }

        for(int j = 1;j<= n;j++){
            dp[0][j] = j;
        }

        for(int i = 1;i<= m;i++){

            for(int j = 1;j<=n;j++){
                //��ֱͬ��ǰ��
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    // ɾ�������롢�滻���ֱ仯
                    dp[i][j] = min(
                            dp[i-1][j] +1,
                            dp[i][j-1] +1,
                            dp[i-1][j-1] +1);
                }
            }
        }
        return dp[m][n];
    }

    int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }

    /**
     * �Զ�����
     */
    String s1,s2;
    public int minDistanceTopDown(String word1, String word2) {
        s1 = word1;
        s2 = word2;
        Map<String,Integer> map = new HashMap<>();
        return helper(s1.length() -1,s2.length() -1,map);
    }

    private int helper(int i, int j, Map map){
        String s = ""+i+" "+j;
        //map�����оͷ��أ������ظ�������
        if(map.containsKey(s)){
            return (int)map.get(s);
        }
        //������ַ���
        if(i == -1){
            return j+1;
        }
        if(j == -1){
            return i+1;
        }

        if(s1.charAt(i) == s2.charAt(j)){
            map.put(s,helper(i-1,j-1,map));
        }else {
            map.put(s,Math.min(Math.min(helper(i-1,j-1,map),helper(i-1,j,map)),helper(i,j-1,map)) + 1);
        }

        return (int)map.get(s);
    }

}
