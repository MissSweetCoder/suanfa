class Solution {

    int[] inDegs;
    List<List<Integer>> edges;
    int n;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 初始化
        n = numCourses;
        inDegs = new int[numCourses];
        edges = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            edges.add(new ArrayList<>());
        }

        // 出边数组
        for(int[] prerequisite : prerequisites){
            int ai = prerequisite[0];
            int bi = prerequisite[1];
            edges.get(bi).add(ai);
            inDegs[ai]++;
        }

        return topSort();
    }

    public int[] topSort(){
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++){
            if(inDegs[i] == 0) q.offer(i);
        }
        int index = 0;
        while(!q.isEmpty()){
            int x = q.poll();
            ans[index++] = x;
            for(int y : edges.get(x)){
                inDegs[y] --;
                if(inDegs[y] == 0) q.offer(y);
            }
        }
        if(index != n) return new int[]{};
        return ans;
    }
}