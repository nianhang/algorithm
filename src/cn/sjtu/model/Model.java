package cn.sjtu.model;

public class Model {


    //�������
    void traverse(int[] arr){

        for(int i = 0;i<arr.length;i++){
            //�������� arr[i]
        }
    }

    //���� ����
    void traverse(ListNode head){
        for(ListNode p = head; p != null; p=p.next){
            //�������� p.val
        }
    }
    //���� �ݹ�
    void traverseRecursion(ListNode head){
        //�ݹ���� head.val
        traverseRecursion(head.next);
    }

    //���������� �����Եݹ�
    void traverse(TreeNode root){
        traverse(root.left);
        traverse(root.right);
    }

    //N��������
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
