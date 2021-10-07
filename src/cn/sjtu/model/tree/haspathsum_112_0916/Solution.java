package cn.sjtu.model.tree.haspathsum_112_0916;

import cn.sjtu.model.tree.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-16 16:02
 * @description：路径总和
 */

public class Solution {
    /**
     * 递归调用
     */

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return recursion(root,0,targetSum);

    }

    public boolean recursion(TreeNode node,int cur,int sum){
        if(node == null) return false;
        cur += node.val;

        if(node.left == null && node.right == null){
            return cur == sum;

        }else {
            return recursion(node.left,cur,sum) || recursion(node.right,cur,sum);
        }
    }

    /**
     * 获取所有路径的总和数列
     * @param node
     * @param cur
     * @return
     */
    List<Integer> result = new LinkedList<>();
    public List<Integer> sumPath(TreeNode node,int cur) {
        if (node == null) return null;
        cur += node.val;
        if (node.left == null && node.right == null) {
            result.add(cur);
        }else {
            sumPath(node.left,cur);
            sumPath(node.right,cur);
        }
        return result;
    }

    /**
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSumWithBFS(TreeNode root, int targetSum) {
        if(root == null) return false;

        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queueVal = new LinkedList<>();

        queNode.offer(root);
        queueVal.offer(root.val);

        while(!queNode.isEmpty()){

            TreeNode node = queNode.poll();
            int tmp = queueVal.poll();

            if(node.left == null && node.right == null){
                if(tmp == targetSum){
                    return true;
                }
                continue;
            }
            if(node.left != null){
                queNode.offer(node.left);
                queueVal.offer(node.left.val + tmp);
            }

            if(node.right != null){
                queNode.offer(node.right);
                queueVal.offer(node.right.val + tmp);
            }
        }
        return false;
    }



}
