package cn.sjtu.model.tree.numtrees_96_0907;

/**
 * @author ：linfd
 * @version :medium$
 * @date ：Created in 2021-10-07 17:13
 * @description：不同的二叉搜索树
 */

public class Solution {

    //第三期 9.06
    /**
     * leetcode 96题   求不同的二叉搜索树(BST)的构造多少种
     * @param n
     * @return
     */
    //备忘录
    int[][] memory;
    public int numTrees(int n) {
        memory = new int[n+1][n+1];
        return count(1,n);
    }
    int count(int lo,int hi){
        //空区间，则结果为1
        if(lo > hi){
            return 1;
        }
        //查备忘录
        if(memory[lo][hi] != 0){
            return memory[lo][hi];
        }

        int res  = 0;
        for(int i = lo; i<= hi; i++){
            //i的值作为根节点 root
            int left = count(lo,i-1);
            int right = count(i+1,hi);
            res += left*right;
        }
        //将结果存入备忘录
        memory[lo][hi] = res;
        return res;
    }


}
