package cn.sjtu.model.listnode.ispalindrome_234_0902;

import cn.sjtu.model.listnode.ListNode;

/**
 * @author ��linfd
 * @version :easy$
 * @date ��Created in 2021-10-07 16:49
 * @description����������
 */

public class Solution {

    /**
     *leetcode ��234�� �жϻ�������
     * @param head
     * @return
     */
    //�ݹ�
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }
    boolean traverse(ListNode right){
        if(right == null) return true;

        boolean res = traverse(right.next);
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }



    //�ǵݹ� ����
    public boolean isPalindromeWithInteration(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null){
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow);

        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    /**
     * ��ת����
     * @param head
     * @return
     */
    ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
