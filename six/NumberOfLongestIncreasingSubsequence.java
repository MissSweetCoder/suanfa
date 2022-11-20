package leetcode.editor.cn;

//给定一个未排序的整数数组
// nums ， 返回最长递增子序列的个数 。
//
// 注意 这个数列必须是 严格 递增的。
//
//
//
// 示例 1:
//
//
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
//
//
// 示例 2:
//
//
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
//
//
//
//
// 提示:
//
//
//
//
//
// 1 <= nums.length <= 2000
// -10⁶ <= nums[i] <= 10⁶
//
//
// Related Topics 树状数组 线段树 数组 动态规划 👍 688 👎 0

public class NumberOfLongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new NumberOfLongestIncreasingSubsequence().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int[] cnt = new int[n];
        for (int i = 0 ; i < n ; i++) {
            f[i] = 1;
            cnt[i] = 1;
        }

        for (int i = 1 ; i < n ; i++){
            for (int j = 0 ; j < i ; j++){
                if (nums[i] > nums[j]){
                    if (f[i] < f[j] + 1){
                        f[i] = f[j] + 1;
                        cnt[i] = cnt[j];
                    }else if (f[i] == f[j] + 1){
                        cnt[i] += cnt[j];
                    }
                }
            }
        }

        int maxLen = 0;
        int ans = 0;
        for (int i = 0 ; i < n ; i++){
           if (f[i] > maxLen){
               maxLen = f[i];
               ans = cnt[i];
           }else if (f[i] == maxLen){
               ans += cnt[i];
           }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
