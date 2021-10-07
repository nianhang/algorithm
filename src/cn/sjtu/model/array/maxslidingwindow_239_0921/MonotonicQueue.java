package cn.sjtu.model.array.maxslidingwindow_239_0921;

import java.util.LinkedList;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-22 19:59
 * @description����������
 */

public class MonotonicQueue {

    //˫����֧��ͷ����β����ɾԪ��
    private LinkedList<Integer> queue = new LinkedList<>();

    public void push(int n){
        //��ǰ��С���Լ���Ԫ�ض�ɾ��
        while(!queue.isEmpty() && queue.getLast() < n){
            queue.pollLast();
        }
        //��n����β��
        queue.addLast(n);
    }

    public int max(){
        //��ͷ��Ԫ�ؿ϶������
        return queue.getFirst();
    }

    public void pop(int n){
        if(n == queue.getFirst()){
            queue.pollFirst();
        }
    }


}
