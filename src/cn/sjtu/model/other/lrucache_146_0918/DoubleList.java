package cn.sjtu.model.other.lrucache_146_0918;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-20 9:34
 * @description：构建双链表
 */

public class DoubleList {
    //头尾虚节点
    private Node head,tail;
    //链表元素数
    private int size;

    public DoubleList(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    //在链表尾部添加节点X，时间为O(1)
    public void addLast(Node x){
        //从X出发的关系
        x.prev = tail.prev;
        x.next = tail;
        //指向X的关系
        tail.prev.next = x;
        tail.prev = x;
        size ++;
    }

    //删除链表中的X节点（x 一定存在）
    //由于是双链表且给的是目标Node节点，时间为O(1)
    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }
    //删除链表中的第一个节点，并返回该节点，时间为O(1)
    public Node removeFirst(){
        if(head.next == tail){
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }
    //返回链表长度，时间为O(1)
    public int size(){
        return size;
    }

}
