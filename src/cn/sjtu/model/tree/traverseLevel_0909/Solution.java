package cn.sjtu.model.tree.traverseLevel_0909;

import cn.sjtu.model.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ��linfd
 * @version :$
 * @date ��Created in 2021-10-07 17:23
 * @description��
 */

public class Solution {

    //�㼶����
    void traverseLevel(TreeNode root){
        if(root == null) return;
        //��ʼ��һ�����У��Ƚ��ȳ�
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode cur = q.poll();

            if(cur == null) continue;
            System.out.println(cur.val);
            /**if(cur.left != null){
             q.offer(cur.left);
             }
             if(cur.right != null){
             q.offer(cur.right);
             }**/
            q.offer(cur.left);
            q.offer(cur.right);
        }
    }

}
