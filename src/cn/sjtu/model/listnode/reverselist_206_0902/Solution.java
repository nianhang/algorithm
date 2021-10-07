package cn.sjtu.model.listnode.reverselist_206_0902;

import cn.sjtu.model.listnode.ListNode;

/**
 * @author ��linfd
 * @version :easy$
 * @date ��Created in 2021-10-07 16:40
 * @description����ת����
 */

public class Solution {

    /**
     * leetcode��206�⣬��ת����
     * @param head
     * @return
     */
    //�ݹ�
    public ListNode reverseList(ListNode head) {
        if(head== null || head.next == null) return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    //�ǵݹ� ������
    public ListNode reverseListWithoutRecur(ListNode head) {
        if(head ==null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head;

        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
