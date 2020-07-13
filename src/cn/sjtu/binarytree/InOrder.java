package cn.sjtu.binarytree;

import java.util.LinkedList;
import java.util.List;

public class InOrder {

    //�ݹ���������
    public void preOrderRecursive(TreeNode root){
        if(root == null){
            return;
        }
        preOrderRecursive(root.left);
        System.out.println(root.val);
        preOrderRecursive(root.right);
    }

    //�ǵݹ���������
    public List<Integer> inOrderTraversal(TreeNode root){
        if(root == null){
            return new LinkedList<>();
        }
        return null;
    }

}
