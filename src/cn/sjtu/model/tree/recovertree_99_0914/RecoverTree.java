package cn.sjtu.model.tree.recovertree_99_0914;

import cn.sjtu.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-14 22:59
 * @description：恢复二叉搜索树
 */

public class RecoverTree {

    /**
     * 恢复二叉搜索树 （用了额外的nums空间数组）
     * @param root
     */
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        inorderTraversal(root,list);
        TreeNode x = null;
        TreeNode y = null;
        //扫面遍历的结果，找出可能存在错误交换的节点x和y
        for(int i = 0;i<list.size() -1;i++){
            if(list.get(i).val > list.get(i+1).val){
                y = list.get(i+1);
                if(x == null){
                    x = list.get(i);
                }
            }
        }

        if(x !=null && y != null){
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    //中序遍历获取所有节点存在list中
    private void inorderTraversal(TreeNode node,List<TreeNode> list){
        if(node == null) return;
        inorderTraversal(node.left,list);
        list.add(node);
        inorderTraversal(node.right,list);
    }

    //中序遍历不带有numbers数组
    private TreeNode x = null;
    private TreeNode y = null;
    private TreeNode pre = null;
    public void recoverTreeWithoutNumbers(TreeNode root) {
        dfs(root);
        if(x != null && y != null){
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }

    }

    private void dfs(TreeNode node){
        if(node == null) return;
        dfs(node.left);
        //中序遍历
        if(pre == null){
            pre = node;
        }else {
            if(pre.val > node.val){
                y = node;
                if(x == null){
                    x = pre;
                }
            }
            pre = node;
        }
        dfs(node.right);
    }




}
