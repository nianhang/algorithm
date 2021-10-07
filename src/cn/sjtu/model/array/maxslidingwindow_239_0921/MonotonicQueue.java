package cn.sjtu.model.array.maxslidingwindow_239_0921;

import java.util.LinkedList;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-22 19:59
 * @description：单调队列
 */

public class MonotonicQueue {

    //双链表，支持头部和尾部增删元素
    private LinkedList<Integer> queue = new LinkedList<>();

    public void push(int n){
        //将前面小于自己的元素都删除
        while(!queue.isEmpty() && queue.getLast() < n){
            queue.pollLast();
        }
        //将n加入尾部
        queue.addLast(n);
    }

    public int max(){
        //对头的元素肯定是最大
        return queue.getFirst();
    }

    public void pop(int n){
        if(n == queue.getFirst()){
            queue.pollFirst();
        }
    }


}
