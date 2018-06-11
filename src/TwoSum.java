import java.util.HashMap;
import java.util.Map;

/**
 * @wangqianjun
 * @create 2017-10-30 23:34
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 **/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        int length = nums.length;
        int key;
        for (int i = 0; i < length; i++) {
            key = target - nums[i];
            Integer global = m.get(key);
            if (global != null) {
                return new int[]{global, i};
            }
            m.put(nums[i], i);
        }
        return null;
    }
}
