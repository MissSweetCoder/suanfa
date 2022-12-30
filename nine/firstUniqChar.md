- 思路：计数问题用hashmap
- 时间复杂度：O（n）
- 空间复杂度：O（n）
```
class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0 ; i < s.length() ; i++){
            int count = map.getOrDefault(s.charAt(i) , 0);
            map.put(s.charAt(i) , ++count);
        }

        for (int i = 0 ; i < s.length() ; i++){
            if (map.get(s.charAt(i)) == 1) return i;
        }

        return -1;
    }
}
```