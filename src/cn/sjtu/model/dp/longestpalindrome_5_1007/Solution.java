package cn.sjtu.model.dp.longestpalindrome_5_1007;

/**
 * @author ��linfd
 * @version :�е�$
 * @date ��Created in 2021-10-07 11:35
 * @description��������Ӵ�
 */

public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "cbbd";
        System.out.println(solution.longestPalindrome(s));

    }

    public String longestPalindrome(String s) {
        String result = "";
        for(int i = 0;i<s.length();i++){
            //��s[i]Ϊ���ĵ�������Ӵ�
            String s1 = palindrome(s, i, i);
            //��s[i]��s[i+1]Ϊ���ĵ�������Ӵ�
            String s2 = palindrome(s,i,i+1);
           //result = longest(res,s1,s2)
            result = result.length() > s1.length() ? result : s1;
            result = result.length() > s2.length() ? result : s2;
        }
        return result;
    }

    private String palindrome(String s,int l,int r){

        while (l >=0 && r< s.length()
                && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        //��s[l]��s[r]Ϊ���ĵ�����Ĵ�
        return s.substring(l+1,r);

    }
}
