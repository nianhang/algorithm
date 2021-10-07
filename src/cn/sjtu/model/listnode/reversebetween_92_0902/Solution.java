package cn.sjtu.model.listnode.reversebetween_92_0902;

import cn.sjtu.model.listnode.ListNode;

/**
 * @author ��linfd
 * @version :medium$
 * @date ��Created in 2021-10-07 16:45
 * @description����ת���� II
 */

public class Solution {

    /**
     *  leetcode ��92�� ��ת�����е�m��N��
     * @param head
     * @param m
     * @param n
     * @return
     */
    ListNode reverseBetween(ListNode head, int m, int n) {
        if(m ==1 ){
            return reverseN(head,n);
        }else {
            // ǰ������ת����㴥�� base case
            head.next = reverseBetween(head.next,m-1,n-1);
        }

        return head;
    }

    /**
     * ��ת����ǰN���ڵ�
     * @param head
     * @return
     */
    ListNode successor = null;
    ListNode reverseN(ListNode head, int n){
        if(n == 1){
            // ��¼�� n + 1 ���ڵ�
            successor = head.next;
            return head;
        }
        // �� head.next Ϊ��㣬��Ҫ��תǰ n - 1 ���ڵ�
        ListNode last = reverseN(head.next,n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

}
