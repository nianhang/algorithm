package cn.sjtu.model.tree.binarytreepaths_257_0913;

import cn.sjtu.model.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-09-13 20:41
 * @description��������������·��
 */

public class BinaryTreePaths {

    /**
     * BFS(�����������)�ǵݹ飬����
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if(root == null) return res;

        Stack<TreeNode> stack = new Stack<>();

        Stack<String> path = new Stack<>();
        //����root�ڵ�
        stack.add(root);
        path.push(root.val+"");
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            String p = path.pop();
            //����Ҷ�ӽڵ��ʱ�򣬼��뵽�������
            if(node.left == null && node.right == null){
                res.add(p);
            }

            if(node.right != null){
                stack.push(node.right);
                //����ʱ·������ѹջ
                path.push(p+"->"+node.right.val);
            }

            if(node.left != null){
                stack.push(node.left);
                //����ʱ·������ѹջ
                path.push(p+"->"+node.left.val);
            }
        }
        return res;
    }

    /**
     * DFS(�����������) �ݹ�
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
