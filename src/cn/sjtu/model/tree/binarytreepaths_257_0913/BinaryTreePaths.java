package cn.sjtu.model.tree.binarytreepaths_257_0913;

import cn.sjtu.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-13 20:41
 * @description：二叉树的所有路径
 */

public class BinaryTreePaths {

    /**
     * BFS(广度优先搜索)非递归，迭代
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if(root == null) return res;

        Stack<TreeNode> stack = new Stack<>();

        Stack<String> path = new Stack<>();
        //加入root节点
        stack.add(root);
        path.push(root.val+"");
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            String p = path.pop();
            //当是叶子节点的时候，加入到结果集中
            if(node.left == null && node.right == null){
                res.add(p);
            }

            if(node.right != null){
                stack.push(node.right);
                //将临时路径继续压栈
                path.push(p+"->"+node.right.val);
            }

            if(node.left != null){
                stack.push(node.left);
                //将临时路径继续压栈
                path.push(p+"->"+node.left.val);
            }
        }
        return res;
    }

    /**
     * DFS(深度优先搜索) 递归
     * @param root
     * @return
     */
    public List<String> binaryTreePathsRec(TreeNode root) {
        List<String> paths = new ArrayList<>();
        traverse(root,"",paths);
        return paths;
    }

    public void traverse(TreeNode root,String path,List<String> paths){
        if(root == null) return;

        StringBuilder pathSB = new StringBuilder(path);
        pathSB.append(Integer.toString(root.val));

        if(root.left == null && root.right == null){
            paths.add(pathSB.toString());
        }else {
            pathSB.append("->");
            traverse(root.left,pathSB.toString(),paths);
            traverse(root.right,pathSB.toString(),paths);
        }

    }


}
