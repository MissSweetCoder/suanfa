package leetcode.editor.cn;

//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
//
//
//
//
//
//
//
// 示例 1：
//
//
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
//
//
// 示例 2：
//
//
//输入：board = [["X"]]
//输出：[["X"]]
//
//
//
//
// 提示：
//
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 200
// board[i][j] 为 'X' 或 'O'
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 890 👎 0

public class SurroundedRegions{
    public static void main(String[] args) {
        Solution solution = new SurroundedRegions().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int m;
    int n;
    char[][] board;

    public void solve(char[][] board) {
        this.board = board;
        m = board.length;
        n = board[0].length;

        for(int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                if((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O'){
                    dfs(i , j);
                }
            }
        }

        for(int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void dfs(int i , int j){
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] == 'X' || board[i][j] == '#'){
            return;
        }
        board[i][j] = '#';

        int[] dx = new int[]{-1 , 0 ,1 , 0};
        int[] dy = new int[]{0 , 1 ,0 , -1};

        for(int k = 0 ; k < 4 ; k++){
            int ni = dx[k] + i;
            int nj = dy[k] + j;
            dfs(ni,nj);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
