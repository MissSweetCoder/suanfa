- 思路：每两个字符串取一次公共子串，一次遍历之后得到所有字符串的公共子串
- 时间复杂度：O（n）
- 空间复杂度：O（1）
```
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }

        String ans = strs[0];
        for (int i = 1 ; i < strs.length ; i++){
            int j = 0;

            for (; j < ans.length() && j < strs[i].length() ; j++){
                if (ans.charAt(j) != strs[i].charAt(j)) break;
            }

            ans = ans.substring(0 , j);
            if (ans == "") return "";
        }

        return ans;
    }
}
```