/**
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * @author wangqianjun
 */
public class LongestPalindrome {


    private int left = 0, maxlength = 0;
    private int length;

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();

        String k = l.longestPalindrome("bab");
        System.out.println(k);
    }

    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        length = s.length();
        for (int i = 0; i < length; ) {
            i = getPalindrome(s, i);

        }
        return s.substring(left, left + maxlength);
    }

    public int getPalindrome(String s, int i) {

        int k = i;
        while (k < length - 1 && s.charAt(k) == s.charAt(k + 1)) k++;
        int next_i = k + 1;

        while (i >= 0 && k < length && s.charAt(i) == s.charAt(k)) {
            i--;
            k++;
        }

        int currenLength = (--k) - (++i) + 1;
        if (maxlength < currenLength) {
            left = i;
            maxlength = currenLength;
        }
        return next_i;
    }

}
