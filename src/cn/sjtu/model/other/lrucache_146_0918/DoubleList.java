package cn.sjtu.model.other.lrucache_146_0918;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-20 9:34
 * @description������˫����
 */

public class DoubleList {
    //ͷβ��ڵ�
    private Node head,tail;
    //����Ԫ����
    private int size;

    public DoubleList(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    //������β����ӽڵ�X��ʱ��ΪO(1)
    public void addLast(Node x){
        //��X�����Ĺ�ϵ
        x.prev = tail.prev;
        x.next = tail;
        //ָ��X�Ĺ�ϵ
        tail.prev.next = x;
        tail.prev = x;
        size ++;
    }

    //ɾ�������е�X�ڵ㣨x һ�����ڣ�
    //������˫�����Ҹ�����Ŀ��Node�ڵ㣬ʱ��ΪO(1)
    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }
    //ɾ�������еĵ�һ���ڵ㣬�����ظýڵ㣬ʱ��ΪO(1)
    public Node removeFirst(){
        if(head.next == tail){
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }
    //���������ȣ�ʱ��ΪO(1)
    public int size(){
        return size;
    }

}
