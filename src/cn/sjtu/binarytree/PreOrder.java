package cn.sjtu.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreOrder {

    //�ݹ��ǰ�����
    public void preOrderRecursive(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    //�ǵݹ��ǰ�����
    public List<Integer> preOrderTraversal(TreeNode root){
        if(root == null){
            return new LinkedList<>();
        }
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);

        while (!stack.isEmpty()){

            TreeNode treeNode = stack.removeFirst();
            result.add(treeNode.val);
            if(treeNode.right != null){
                stack.addFirst(treeNode.right);
            }
            if(treeNode.left != null){
                stack.addFirst(treeNode.left);
            }
        }
        return result;
    }



}
