package cn.sjtu.model.tree.preordertraversal_144_0913;

import cn.sjtu.model.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-13 19:48
 * @description：前序遍历
 */

public class PreorderTraversal {

    //递归
    List<Integer> res = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return res;

        res.add(root.val);
        if(root.left != null){
            preorderTraversal(root.left);
        }

        if(root.right != null){
            preorderTraversal(root.right);
        }
        return res;
    }

    //迭代
    public List<Integer> preorderTraversalIteration(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //先右节点，再左节点，再通过栈就能先序遍历
        while(!stack.isEmpty()){

            TreeNode node = stack.pop();
            result.add(node.val);

            if(node.right != null){
                stack.push(node.right);
            }

            if(node.left != null){
                stack.push(node.left);
            }

        }
        return result;
    }

}
