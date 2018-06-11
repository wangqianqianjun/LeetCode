/**
 * @wangqianjun
 * @create 2017-10-30 23:55
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 **/
public class Reverse {

    public static void main(String[] args) {
        Reverse r = new Reverse();
        int k = 1534236469;

        System.out.println(r.reverse(k));
    }

    public int reverse(int x) {
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
            return 0;
        }
        int k = x < 0 ? x * -1 : x;
        int res = 0;
        while (k != 0) {
            if ((res * 10 + k % 10) < ((long) res * 10 + (long) k % 10)) {
                return 0;
            }
            res = res * 10 + x % 10;
            k = k / 10;
        }
        if (x < 0) {
            res = res * (-1);
        }
        return res;
    }
}
