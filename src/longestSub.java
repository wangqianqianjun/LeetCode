/**
 * Created by wangqianjun on 2017/10/26.
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class longestSub {


    public static void main(String[] args) {
        longestSub l = new longestSub();
        String a = "dvdf";
        System.out.println(l.lengthOfLongestSubstring(a));
    }


    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        int[] seq = new int[256];
        int l = 0, r = -1, res = 0;
        char[] c = s.toCharArray();
        int length = c.length;
        while (l < length) {
            if (r + 1 < length && seq[c[r + 1]] == 0) {
                seq[c[++r]]++;
            } else {
                seq[c[l++]]--;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
