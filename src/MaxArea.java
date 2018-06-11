/**
 * @wangqianjun
 * @create 2017-10-30 23:06
 * <p>
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water
 **/
public class MaxArea {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        int area;
        while (left < right) {
            if (height[left] < height[right]) {
                area = (right - left) * height[left];
                left++;
            } else {
                area = (right - left) * height[right];
                right--;
            }
            if (area > maxArea) {
                maxArea = area;
            }

        }

        return maxArea;

    }

}
