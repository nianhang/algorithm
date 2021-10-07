package cn.sjtu.model.other.myqueue_232_0921;

import java.util.Stack;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-21 23:47
 * @description����ջʵ�ֶ���
 */

public class MyQueue {

    //������ջʵ�ֶ���
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //��֤stack2�ǿ�
        peek();
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        //��Ҫ�ж�stack2�ǿգ�Ȼ���stack1����stack2��
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
