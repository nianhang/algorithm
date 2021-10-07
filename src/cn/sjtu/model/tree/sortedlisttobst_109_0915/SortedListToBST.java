package cn.sjtu.model.tree.sortedlisttobst_109_0915;

import cn.sjtu.model.listnode.ListNode;
import cn.sjtu.model.tree.TreeNode;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-15 20:56
 * @description：有序链表转换二叉搜索树
 */

public class SortedListToBST {

    /**
     * 分治+递归
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return buildTree(head,null);
    }

    public TreeNode buildTree(ListNode left,ListNode right){
        if(left == right) return null;

        ListNode midListNode = getMidListNode(left, right);
        TreeNode root = new TreeNode(midListNode.val);
        //[左闭右开]即[left,midListNode) 和 [midListNode.next,right)
        root.left = buildTree(left,midListNode);
        root.right = buildTree(midListNode.next,right);
        return root;
    }

    //找到两个节点之间的中间节点
    public ListNode getMidListNode(ListNode left,ListNode right){
        ListNode fast = left;
        ListNode slow = left;

        while(fast != right && fast.next != right){
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 中序遍历+分治
     * @param head
     * @return
     */

    ListNode ptr;
    public TreeNode sortedListToBSTWithInorder(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);

        ptr = head;
        return buildTree(0,getLength(head) -1);
    }
    public int getLength(ListNode head){
        int length = 0;
        while (head != null){
            head = head.next;
            length++;
        }
        return length;
    }
    //中序遍历
    public TreeNode buildTree(int left,int right){
        if(left > right){
            return null;
        }

        int mid = left + (right - left +1)/2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left,mid-1);
        root.val = ptr.val;
        // pre指针步进
        ptr = ptr.next;
        root.right = buildTree(mid+1,right);
        return root;
    }


}
