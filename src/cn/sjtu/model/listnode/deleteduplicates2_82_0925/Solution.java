package cn.sjtu.model.listnode.deleteduplicates2_82_0925;

import cn.sjtu.model.listnode.ListNode;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-25 16:00
 * @description��ɾ�����������е��ظ�Ԫ�� II���ظ�ȫ��ɾ����
 */

public class Solution {

    /**
     * �ݹ�
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dumpy = new ListNode(-1,head);
        ListNode cur = dumpy;

        while(cur.next != null && cur.next.next != null){
            //��ȵ�ʱ��ɾ��
            if(cur.next.val == cur.next.next.val){
                int duplicatesNum = cur.next.val;
                //ɾ��ȫ���ظ�������
                while(cur.next != null && cur.next.val == duplicatesNum){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }
        return dumpy.next;

    }

    /**
     * �ݹ�
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesWithRecursion(ListNode head) {
        // û�нڵ����ֻ��һ���ڵ㣬��Ȼû���ظ�Ԫ��
        if(head == null || head.next == null) return head;

        // ��ǰ�ڵ����һ���ڵ㣬ֵ��ͬ����head��ֵ����Ҫ�����ģ���head.next�����ݹ�
        if(head.val != head.next.val){
            head.next = deleteDuplicatesWithRecursion(head.next);
            return head;
        }else {
            // ��ǰ�ڵ�����һ���ڵ��ֵ�ظ��ˣ��ظ���ֵ������Ҫ��
            // һֱ�����ң��ҵ����ظ��Ľڵ㡣���ضԲ��ظ��ڵ�ĵݹ���
            ListNode notDup = head.next.next;
            while(notDup != null && notDup.val == head.val){
                notDup = notDup.next;
            }
            return deleteDuplicatesWithRecursion(notDup);
        }


    }

}
