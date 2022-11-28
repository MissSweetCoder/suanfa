- k是第i步能到的最远距离，要是i+1>k了，那肯定就到不了最后一个数，这个属于贪心算法了，不知道为啥出在这
- 时间复杂度：o(N)
- 空间复杂度：o(N)

```
class Solution {
    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0 ; i < nums.length ; i++){
            if(i > k) return false;
            k = Math.max(k , i+nums[i]);
        }
        return true;
    }
}
```