- 思路：遍历边，找到点，一个边的两个点如果不连通，就让它们连通，如果连通，说明找到环了
- 时间复杂度：O(nα(n))
- 空间复杂度：O(n)
```
class Solution {

    int[] fa;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        fa = new int[n + 1];
        for (int i = 0 ; i < fa.length ; i++) fa[i] = i;

        for (int i = 0 ; i < edges.length ; i++){
            int[] edge = edges[i];
            int start = edge[0];
            int end = edge[1];
            if (find(start) != find(end)){
                unionSet(start , end);
            }else {
                return edge;
            }
        }

        return new int[]{};
    }

    public int find(int x){
        if (fa[x] == x) return x;
        return fa[x] = find(fa[x]);
    }

    public void unionSet(int i , int j){
        int x = find(i);
        int y = find(j);
        if (x != y) fa[x] = y;
    }
}
```