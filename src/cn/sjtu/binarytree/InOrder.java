package cn.sjtu.binarytree;

import java.util.LinkedList;
import java.util.List;

public class InOrder {

    //递归的中序遍历
    public void preOrderRecursive(TreeNode root){
        if(root == null){
            return;
        }
        preOrderRecursive(root.left);
        System.out.println(root.val);
        preOrderRecursive(root.right);
    }

    //非递归的中序遍历
    public List<Integer> inOrderTraversal(TreeNode root){
        if(root == null){
            return new LinkedList<>();
        }
        return null;
    }

}
