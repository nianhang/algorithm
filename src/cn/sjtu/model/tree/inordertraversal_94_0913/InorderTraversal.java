package cn.sjtu.model.tree.inordertraversal_94_0913;

import cn.sjtu.model.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-12 21:39
 * @description：中序遍历
 */

public class InorderTraversal {
    public static void main(String[] args) {

    }

    //递归
    List<Integer> res = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return res;
        if(root.left != null){
            inorderTraversal(root.left);
        }

        res.add(root.val);

        if(root.right != null){
            inorderTraversal(root.right);
        }

        return res;
    }

    //迭代
    public List<Integer> inorderTraversalIteration(TreeNode root){
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;
        //设置一个栈stack，来作为中序遍历的中间节点
        Stack<TreeNode> stack = new Stack<>();
        //当前节点不为空，或者栈不为空
        while(!stack.isEmpty() || root != null){
            //加了所有的左节点中
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            //加上所有的右节点中
            if(!stack.isEmpty()){
                TreeNode node = stack.pop();
                result.add(node.val);
                root = node.right;
            }
        }
        return result;
    }




}
