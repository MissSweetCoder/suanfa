- 思路：比较简单，我看题解有人用位运算做，基本跟那个是一个意思的，但是相对直观一点
- 时间复杂度：O(n)
- 空间复杂度：O(n)
```
class Solution {
    public String toLowerCase(String s) {
        char[] ch = s.toCharArray();
        int num = 'A' - 'a';
        for (int i = 0 ; i < ch.length ; i++){
            if (ch[i] >= 'A' && ch[i] <= 'Z'){
                ch[i] -= num;
            }
        }
        return new String(ch);
    }
}
```