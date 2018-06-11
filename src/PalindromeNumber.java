/**
 * @wangqianjun
 * @create 2017-10-31 00:27
 * Determine whether an integer is a palindrome. Do this without extra space.
 **/
public class PalindromeNumber {

    public static void main(String[] args) {
        int m = 9;
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.isPalindrome(m));

    }

    public boolean isPalindrome(int x) {
        int res = 0;
        if (x == 0) return true;
        if (x % 10 == 0) return false;
        while (x > 0) {
            res = res * 10 + x % 10;
            if (res > x) {
                return false;
            }
            if (res == x || res == (x /= 10)) {
                return true;
            }
        }
        return false;
    }
}
