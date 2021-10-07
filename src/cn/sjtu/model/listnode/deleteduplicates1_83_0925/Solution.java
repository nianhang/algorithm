package cn.sjtu.model.listnode.deleteduplicates1_83_0925;

import cn.sjtu.model.listnode.ListNode;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-25 15:44
 * @description��ȥ���ظ���ĸ(��������һ��)
 */

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        //Ӧ�ÿ���ָ����
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null){
            if(fast.val != slow.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        //�Ͽ����ڵ�
        slow.next = null;
        return head;
    }

}
