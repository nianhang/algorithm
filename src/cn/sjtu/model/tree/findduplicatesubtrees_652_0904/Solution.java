package cn.sjtu.model.tree.findduplicatesubtrees_652_0904;

import cn.sjtu.model.tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：linfd
 * @version :medium$
 * @date ：Created in 2021-10-07 17:02
 * @description：寻找重复的子树
 */

public class Solution {

    /**
     * leetcode 652题 寻找重复的子树
     * @param root
     * @return
     */
    HashMap<String,Integer> memo = new HashMap<>();
    LinkedList<TreeNode> res = new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    String traverse(TreeNode root){
        if(root == null) return null;

        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left+"," + right + "," + root.val;

        Integer freq = memo.getOrDefault(subTree, 0);
        // 多次重复也只会被加入结果集一次
        if(freq == 1){
            res.add(root);
        }
        // 给子树对应的出现次数加一
        memo.put(subTree,freq+1);
        return subTree;

    }

}
