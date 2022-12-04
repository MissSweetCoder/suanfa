-思路：遍历网格，从一个'1'开始，找到跟它相连的所有'1'并连通，之后找到所有数组中值为1的根节点并累加就行
- 时间复杂度：O(MN×α(MN))
- 空间复杂度：O(MN)
```
class Solution {

    int[] fa;

    int m , n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        fa = new int[m * n];
        for (int i = 0 ; i < fa.length ; i++) fa[i] = i;

        int[] dx = {-1 , 0 , 1 , 0};
        int[] dy = {0 , 1 , 0 , -1};

        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                if (grid[i][j] == '0') continue;

                for (int k = 0 ; k < 4 ; k++){
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    if (ni < 0 || ni >= m || nj <0 || nj>= n) continue;
                    if (grid[ni][nj] == '1'){
                        unionSet(num(i , j) , num(ni , nj));
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0 ; i < fa.length ; i++){
            if (fa[i] == i && grid[i / n][i % n]  == '1') {
                ans++;
            }
        }
        return ans;
    }

    public int num(int i , int j){
        return i * n + j;
    }

    public int find(int x){
        if (x == fa[x]) return x;
        return fa[x] = find(fa[x]);
    }

    public void unionSet(int x , int y){
        x = find(x);
        y = find(y);
        if (x != y) fa[x] = y;
    }
}
```