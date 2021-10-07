package cn.sjtu.model.dp.minimumdeletesum_712_1006;

import java.util.Arrays;

/**
 * @author ��linfd
 * @version :�е�$
 * @date ��Created in 2021-10-07 1:06
 * @description�������ַ�������СASCIIɾ����
 */

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "fardfae";
        String s2 = "refaraf";

        System.out.println(solution.minimumDeleteSum(s1,s2));

    }


    //����¼�������ص�������
    int[][] memo;
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // ����¼ֵΪ -1 ����δ������
        memo = new int[m][n];
        for(int[] row : memo){
            Arrays.fill(row,-1);
        }
        return dp(s1,0,s2,0);
    }

    // ���壺�� s1[i..] �� s2[j..] ɾ������ͬ�ַ�����
    // ��С�� ASCII ��֮��Ϊ dp(s1, i, s2, j)��
    private int dp(String s1,int i,String s2,int j){
        int res = 0;
        // base case
        if(i == s1.length()){
            // ��� s1 ��ͷ�ˣ���ô s2 ʣ�µĶ���ɾ��
            for(;j<s2.length();j++){
                res += s2.charAt(j);
            }
            return res;
        }

        if(j == s2.length()){
            // ��� s2 ��ͷ�ˣ���ô s1 ʣ�µĶ���ɾ��
            for(;i<s1.length();i++){
                res += s1.charAt(i);
            }
            return res;
        }

        // ���֮ǰ���������ֱ�ӷ��ر���¼�еĴ�
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        // ���� s1[i] �� s2[j] �Ƿ������ѡ��
        if(s1.charAt(i) == s2.charAt(j)){
            // s1[i] �� s2[j] ������ lcs �еģ�����ɾ��
            memo[i][j] = dp(s1,i+1,s2,j+1);
        }else {
            // s1[i] �� s2[j] ������һ������ lcs �У�ɾһ��
            memo[i][j] = Math.min(
                    //s1[i]���� lcs ��
                    s1.charAt(i) + dp(s1,i+1,s2,j),
                    //s2[j]���� lcs ��
                    s2.charAt(j) + dp(s1,i,s2,j+1));
        }
        return memo[i][j];
    }
}
