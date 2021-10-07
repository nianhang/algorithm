package cn.sjtu.model.listnode.removenthfromend_19_0901;

import cn.sjtu.model.listnode.ListNode;

/**
 * @author ��linfd
 * @version :medium$
 * @date ��Created in 2021-10-07 16:20
 * @description��ɾ������ĵ����� N �����
 */

public class Solution {

    /**
     * leetcode��19�⣬ɾ������ĵ�����N���ڵ�
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // ����ͷ�ڵ�
        ListNode dump = new ListNode();
        dump.next = head;
        // ɾ�������� n ����Ҫ���ҵ����� n + 1 ���ڵ�
        ListNode x = findFromEnd(head, n + 1);
        // ɾ�������� n ���ڵ�
        x.next = x.next.next;
        return dump.next;
    }

    ListNode findFromEnd(ListNode head,int k){
        ListNode p1 = head;
        for(int i=0;i<k;i++){
            p1 = p1.next;
        }
        ListNode p2 = head;
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }


}
