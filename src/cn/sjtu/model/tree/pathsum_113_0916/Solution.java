package cn.sjtu.model.tree.pathsum_113_0916;

import cn.sjtu.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-16 20:54
 * @description：路径总和 II(找出所有路径和等于给定值的所有路径)
 */

public class Solution {

    /**
     * BFS
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //listQueue
        Queue<List<Integer>> listQueue = new LinkedList<>();
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        listQueue.offer(rootList);

        Queue<Integer> sumQueue = new LinkedList<>();
        sumQueue.offer(root.val);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            int temp = sumQueue.poll();
            List<Integer> list = listQueue.poll();
            //新建左子树的路径
            List<Integer> leftList = new ArrayList<>(list);
            //新建右子树的路径
            List<Integer> rightList = new ArrayList<>(list);

            if(node.left == null && node.right == null){
                if(temp == targetSum){
                    result.add(list);
                }
                continue;
            }
            if(node.left != null){
                queue.offer(node.left);
                sumQueue.offer(node.left.val + temp);
                leftList.add(node.left.val);
                listQueue.offer(leftList);
            }

            if(node.right != null){
                queue.offer(node.right);
                sumQueue.offer(node.right.val + temp);
                rightList.add(node.right.val);
                listQueue.offer(rightList);
            }

        }
        return result;
    }

    /**
     * 递归
     * @param root
     * @param targetSum
     * @return
     */
    List<List<Integer>> result = new LinkedList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSumWithRecursion(TreeNode root, int targetSum) {
        dfs(root,targetSum);
        return result;
    }

    public void dfs(TreeNode root,int sum){
        if(root == null) return;
        sum -= root.val;
        path.add(root.val);

        if(root.left == null && root.right == null && sum ==0){
            result.add(new ArrayList<>(path));
        }
        dfs(root.left,sum);
        dfs(root.right,sum);
        path.remove(path.size() -1);
    }

}
