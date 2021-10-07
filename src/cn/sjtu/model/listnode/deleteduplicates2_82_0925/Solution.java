package cn.sjtu.model.listnode.deleteduplicates2_82_0925;

import cn.sjtu.model.listnode.ListNode;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-25 16:00
 * @description：删除排序链表中的重复元素 II（重复全部删除）
 */

public class Solution {

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dumpy = new ListNode(-1,head);
        ListNode cur = dumpy;

        while(cur.next != null && cur.next.next != null){
            //相等的时候删除
            if(cur.next.val == cur.next.next.val){
                int duplicatesNum = cur.next.val;
                //删除全部重复的数据
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
     * 递归
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesWithRecursion(ListNode head) {
        // 没有节点或者只有一个节点，必然没有重复元素
        if(head == null || head.next == null) return head;

        // 当前节点和下一个节点，值不同，则head的值是需要保留的，对head.next继续递归
        if(head.val != head.next.val){
            head.next = deleteDuplicatesWithRecursion(head.next);
            return head;
        }else {
            // 当前节点与下一个节点的值重复了，重复的值都不能要。
            // 一直往下找，找到不重复的节点。返回对不重复节点的递归结果
            ListNode notDup = head.next.next;
            while(notDup != null && notDup.val == head.val){
                notDup = notDup.next;
            }
            return deleteDuplicatesWithRecursion(notDup);
        }


    }

}
