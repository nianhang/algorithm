package cn.sjtu.model.tree.sumnumbers_129_0916;

import cn.sjtu.model.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-16 22:18
 * @description：求根节点到叶节点数字之和
 */

public class Solution {

    /**
     * 递归
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        List<Integer> list = sumPath(root, 0);
        int sum = 0;
        for(int num : list){
            sum +=num;
        }
        return sum;
    }

    List<Integer> result = new LinkedList<>();
    public List<Integer> sumPath(TreeNode node,int cur) {
        if (node == null) return null;
        cur = cur * 10;
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
     * BFS的解法
     * @param root
     * @return
     */
    public int sumNumbersWithBFS(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        int total = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> numberQueue = new LinkedList<>();
        queue.offer(root);
        numberQueue.offer(root.val);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                TreeNode node = queue.poll();
                Integer sum = numberQueue.poll();
                if (node.left == null && node.right == null) {
                    result.add(sum);
                }
                if(node.left != null){
                    queue.offer(node.left);
                    numberQueue.offer(sum*10 + node.left.val);
                }
                if(node.right != null){
                    queue.offer(node.right);
                    numberQueue.offer(sum*10 + node.right.val);
                }
            }
        }
        for(Integer num : result){
            total += num;
        }
        return total;

    }

}
