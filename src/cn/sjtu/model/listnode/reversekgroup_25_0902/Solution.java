package cn.sjtu.model.listnode.reversekgroup_25_0902;

import cn.sjtu.model.listnode.ListNode;

/**
 * @author ��linfd
 * @version :hard$
 * @date ��Created in 2021-10-07 16:47
 * @description��K ��һ�鷭ת����
 */

public class Solution {

    /**
     * leetcode ��25�� K��һ�鷭ת����
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode a = head;
        ListNode b = head;
        for(int i = 0; i<k; i++){
            if(b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b,k);
        return newHead;
    }

    /**
     * ��תa->b֮�������
     * @param a
     * @param b
     * @return
     */
    ListNode reverse(ListNode a,ListNode b){
        ListNode pre = null;
        ListNode cur = a;
        ListNode next = b;

        while(cur != b){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
