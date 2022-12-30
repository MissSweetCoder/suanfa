- 思路：用hashset实现记录功能
- 时间复杂度：O（m+n）
- 空间复杂度：O（m）
```
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (int i = 0 ; i < jewels.length() ; i++){
            set.add(jewels.charAt(i));
        }

        int ans = 0;
        for (int i = 0 ; i < stones.length() ; i++){
            if (set.contains(stones.charAt(i))) ans++;
        }

        return ans;
    }
}
```