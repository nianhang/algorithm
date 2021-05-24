package cn.sjtu.model;

public class Model {


    //数组迭代
    void traverse(int[] arr){

        for(int i = 0;i<arr.length;i++){
            //迭代访问 arr[i]
        }
    }

    //链表 迭代
    void traverse(ListNode head){
        for(ListNode p = head; p != null; p=p.next){
            //迭代访问 p.val
        }
    }
    //链表 递归
    void traverseRecursion(ListNode head){
        //递归访问 head.val
        traverseRecursion(head.next);
    }

    //二叉树遍历 非线性递归
    void traverse(TreeNode root){
        traverse(root.left);
        traverse(root.right);
    }

    //N叉树遍历
    void traverse(TreeNodeN root){
        for(TreeNodeN child : root.children){
                traverse(child);
        }
    }


}

class ListNode{
    int val;
    ListNode next;
}

class TreeNode{
    int val;
    TreeNode left,right;
}

class TreeNodeN{
    int val;
    TreeNodeN[] children;
}
