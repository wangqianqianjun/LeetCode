/**
 * @wangqianjun
 * @create 2017-10-31 22:42
 * We have two special characters.
 * The first character can be represented by one bit 0.
 * The second character can be represented by two bits (10 or 11).
 * Now given a string represented by several bits.
 * Return whether the last character must be a one-bit character or not.
 * The given string will always end with a zero.
 **/
public class OneBitCharacter {

    public boolean isOneBitCharacter(int[] bits) {
        int k = 0, length = bits.length - 2;
        while (length >= 0 && bits[length--] == 1) k++;
        return k % 2 == 0 ? true : false;
    }
}
