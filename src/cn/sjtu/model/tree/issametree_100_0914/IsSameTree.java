package cn.sjtu.model.tree.issametree_100_0914;

import cn.sjtu.model.tree.TreeNode;

/**
 * @author £ºlinfd
 * @version :$
 * @date £ºCreated in 2021-09-14 19:34
 * @description£ºÏàÍ¬µÄÊ÷
 */

public class IsSameTree {
    //µÝ¹é
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null) return true;

        if(p != null && q != null){
            if(p.val == q.val){
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            }
        }
            return false;
    }

}
