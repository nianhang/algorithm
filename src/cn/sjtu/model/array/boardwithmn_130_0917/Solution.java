package cn.sjtu.model.array.boardwithmn_130_0917;

/**
 * @author ：linfd
 * @version :$
 * @date ：Created in 2021-09-17 23:33
 * @description：被围绕的区域
 */

public class Solution {


    public static void main(String[] args) {

        Solution solution = new Solution();
        char[][] board={ {'X','X','X'},{'X','O','O'},{'X','X','O'},{'X','O','X'} };
        solution.solve(board);
    }

    /**
     * 用深度优先搜索dfs
     * @param board
     */
    int n,m;
    public void solve(char[][] board) {
        n = board.length;
        if(n == 0) return;
        m = board[0].length;
        for(int i =0; i< n;i++){
            dfs(board,i,0);
            dfs(board,i,m-1);
        }
        for(int k =0;k < m-1;k++){
            dfs(board,0,k);
            dfs(board,n-1,k);
        }

        for(int i =0;i < n;i++){
            for(int j =0;j < m;j++){
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void dfs(char[][] board,int x,int y){
        if(x < 0 || x >= n || y < 0 || y >= m || board[x][y] !='O'){
            return;
        }
        board[x][y] = 'A';
        dfs(board,x+1,y);
        dfs(board,x-1,y);
        dfs(board,x,y+1);
        dfs(board,x,y-1);
    }

}
