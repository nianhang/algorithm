package cn.sjtu.model.array.removeduplicateletters_316_0925;

import java.util.Stack;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-25 11:45
 * @description��ȥ���ظ���ĸ
 */

public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "bcabc";
        String res = solution.removeDuplicateLetters(s);
        System.out.println(res);
    }

    public String removeDuplicateLetters(String s) {

        Stack<Character> stack = new Stack<>();
        //ά���Ƿ�����ظ������
        boolean[] isStack = new boolean[256];
        int n = s.length();

        // ά��һ����������¼�ַ������ַ�������
        // ��Ϊ����Ϊ ASCII �ַ�����С 256 ������
        int[] count = new int[256];

        for(int k = 0;k < n;k++){
            count[s.charAt(k)]++;
        }

        for(int i = 0;i < n;i++){
            char c = s.charAt(i);
            // ÿ������һ���ַ���������Ӧ�ļ�����һ
            count[c]--;
            if(isStack[c]){
                continue;
            }
            //����ջ�Ĺ���
            while(!stack.isEmpty() && stack.peek() > c){
                // ��֮�󲻴���ջ��Ԫ���ˣ���ֹͣ pop
                if(count[stack.peek()] == 0){
                    break;
                }
                // ����ջ��Ԫ�أ����Ѹ�Ԫ�ر��Ϊ����ջ��
                isStack[stack.pop()] = false;
            }

            stack.push(c);
            isStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }


}
