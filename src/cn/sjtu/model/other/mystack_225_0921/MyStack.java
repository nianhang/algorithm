package cn.sjtu.model.other.mystack_225_0921;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-21 23:47
 * @description：用队列实现栈
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
        //x是队列的队尾，是栈的栈顶
        queue.offer(x);
        topElem = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queue.size();
        //留下队尾2个元素,为了更新topElem，即栈的栈顶元素
        while(size > 2){
            queue.offer(queue.poll());
            size --;
        }
        //记录新的队尾元素
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
