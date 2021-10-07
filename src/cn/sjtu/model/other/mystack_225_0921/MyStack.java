package cn.sjtu.model.other.mystack_225_0921;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-21 23:47
 * @description���ö���ʵ��ջ
 */

public class MyStack {

    Queue<Integer> queue;
    int topElem;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
        topElem = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        //x�Ƕ��еĶ�β����ջ��ջ��
        queue.offer(x);
        topElem = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queue.size();
        //���¶�β2��Ԫ��,Ϊ�˸���topElem����ջ��ջ��Ԫ��
        while(size > 2){
            queue.offer(queue.poll());
            size --;
        }
        //��¼�µĶ�βԪ��
        topElem = queue.peek();
        queue.offer(queue.poll());

        return queue.poll();

    }

    /** Get the top element. */
    public int top() {
        return topElem;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();

    }


}
