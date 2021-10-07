package cn.sjtu.model.tree.postordertraversal_145_0913;

import cn.sjtu.model.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-13 20:06
 * @description：后序遍历
 */

public class PostorderTraversal {

    /**
     * 递归
     */
    List<Integer> res = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return res;
        if(root.left != null){
            postorderTraversal(root.left);
        }
        if(root.right != null){
            postorderTraversal(root.right);
        }
        res.add(root.val);
        return res;
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalIteration(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;

        Stack<TreeNode> stackA = new Stack<>();
        Stack<TreeNode> stackB = new Stack<>();

        stackA.push(root);
        //stackA不为空
        while(!stackA.isEmpty()){
            TreeNode nodeA = stackA.pop();
            stackB.push(nodeA);
            if(nodeA.left != null){
                stackA.push(nodeA.left);
            }
            if(nodeA.right != null){
                stackA.push(nodeA.right);
            }
        }
        while(!stackB.isEmpty()){
            TreeNode nodeB = stackB.pop();
            res.add(nodeB.val);
        }
        return res;
    }

}
