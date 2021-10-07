package cn.sjtu.model.array.removeduplicateletters_316_0925;

import java.util.Stack;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-25 11:45
 * @description：去除重复字母
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
        //维护是否存在重复的情况
        boolean[] isStack = new boolean[256];
        int n = s.length();

        // 维护一个计数器记录字符串中字符的数量
        // 因为输入为 ASCII 字符，大小 256 够用了
        int[] count = new int[256];

        for(int k = 0;k < n;k++){
            count[s.charAt(k)]++;
        }

        for(int i = 0;i < n;i++){
            char c = s.charAt(i);
            // 每遍历过一个字符，都将对应的计数减一
            count[c]--;
            if(isStack[c]){
                continue;
            }
            //单调栈的构造
            while(!stack.isEmpty() && stack.peek() > c){
                // 若之后不存在栈顶元素了，则停止 pop
                if(count[stack.peek()] == 0){
                    break;
                }
                // 弹出栈顶元素，并把该元素标记为不在栈中
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
