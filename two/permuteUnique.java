class Solution {
    
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> per = new ArrayList<>();
    private boolean[] used ;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        recur(0,nums);
        return ans;
    }

    public void recur(int index,int[] nums){
        if(index == nums.length){
            ans.add(new ArrayList<>(per));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(used[i] || i > 0 && nums[i - 1] == nums[i] && !used[i-1]) continue;
            used[i] = true;
            per.add(nums[i]);
            recur(index + 1 , nums);
            used[i] = false;
            per.remove(index);
        } 
    }
}