- 思路：比较简单，直接用java的api做了
- 时间复杂度跟空间复杂度不太直观了=.=
```
class Solution {
    public int lengthOfLastWord(String s) {
        int index = s.trim().lastIndexOf(" ");
        String substr = s.substring(index+1 , s.trim().length());
        return substr.length();
    }
}
```