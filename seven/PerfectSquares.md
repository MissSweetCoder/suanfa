- 解题思路：一个状态：i代表和值（总容量），一个变量：j代表被平方数（背包），f(i)代表和为i时的完全平方数的最少数量，动规方程：f(i) = min(f(i-j*j)+1)
- 时间复杂度：o(N * 根号N)
- 空间复杂度：o(N)
```
class Solution {
    public int numSquares(int n) {
        int[] f = new int[n+1];
        Arrays.fill(f,Integer.MAX_VALUE);
        f[0] = 0;
        for(int i = 1 ; i < n+1 ; i++){
            for (int j = 1 ; j * j <= i ; j++){
                f[i] = Math.min(f[i] , f[i - j * j] + 1);
            }
        }
        return f[n];
    }
}
```