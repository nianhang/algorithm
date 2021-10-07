package cn.sjtu.model.listnode.middlenode_876_0901;

import cn.sjtu.model.listnode.ListNode;

/**
 * @author ��linfd
 * @version :easy$
 * @date ��Created in 2021-10-07 16:26
 * @description��������м���
 */

public class Solution {

    /**
     * leetcode��876�⣬�ҳ�������м���
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
