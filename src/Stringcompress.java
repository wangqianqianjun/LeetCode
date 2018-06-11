/**
 * @wangqianjun
 * @create 2017-10-31 23:29
 * Given an array of characters, compress it in-place.
 * The length after compression must always be smaller than or equal to the original array.
 * Every element of the array should be a character (not int) of length 1.
 * After you are done modifying the input array in-place, return the new length of the array.
 * Example 1:
 * Input:
 * ["a","a","b","b","c","c","c"]
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 **/
public class Stringcompress {
    public static void main(String[] args) {

    }

    public int compress(char[] chars) {
        int j = 0, length = chars.length, count = 1;
        String s = "";
        for (int i = 1; i <= length; i++, count++) {
            if (i < length && chars[i] == chars[i - 1]) continue;
            chars[j++] = chars[i - 1];
            if (count != 1) {
                s = Integer.valueOf(count).toString();
                for (int k = 0; k < s.length(); k++) {
                    chars[j++] = s.charAt(k);
                }
            }
            count = 0;
        }
        return j;
    }


}

