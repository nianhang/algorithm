package cn.sjtu.model.tree.levelorderbottom_107_0913;

import cn.sjtu.model.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-13 22:36
 * @description：二叉树的层次遍历从底往上
 */

public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        Stack<List<Integer>> stack = new Stack<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            List<Integer> back = new LinkedList<>();
            int size = queue.size();
            for(int i = 0;i< size;i++){
                TreeNode node = queue.poll();
                back.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            stack.push(back);
        }
        while(!stack.isEmpty()){
            List<Integer> nodeList = stack.pop();
            res.add(nodeList);
        }
        return res;
    }



}
