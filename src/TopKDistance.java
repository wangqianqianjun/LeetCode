/**
 * @wangqianjun
 * @create 2017-11-04 11:25
 * Given an integer array, return the k-th smallest distance among all the pairs.
 * The distance of a pair (A, B) is defined as the absolute difference between A and B.
 * Input:
 * nums = [1,3,1]
 * k = 1
 * Output: 0
 * Explanation:
 * Here are all the pairs:
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 **/
public class TopKDistance {


    public static void main(String[] args) {
        TopKDistance t = new TopKDistance();
        int[] k = new int[]{2, 0, 0, 1, 1, 0};

        int p = t.smallestDistancePair(k, 2);
        System.out.println(p);

    }

    public int smallestDistancePair(int[] nums, int k) {
        int l = nums.length;
        int len = l * (l - 1) / 2;
        int[] sumArr = new int[len];
        int c = 0;
        for (int i = 0; i < l - 1; i++) {
            for (int j = i + 1; j < l; j++) {
                sumArr[c++] = Math.abs(nums[j] - nums[i]);
            }
        }

        int topDistance = topKSize(sumArr, 0, len - 1, k);

        return topDistance;
    }


    public int topKSize(int[] num, int left, int right, int target) {
        if (num.length == 1) {
            return num[0];
        }
        int mid = getPivotMide(num, left, right);
        int q = randomPartion(num, left, right, mid);
        int k = q - left + 1;

        if (k == target) return num[q];

        if (k > target) return topKSize(num, left, q - 1, target);
        else return topKSize(num, q + 1, right, target - k);
    }

    ;


    public int randomPartion(int[] nums, int left, int right, int mid) {
        swap(nums, mid, right);
        int i = left, j = right - 1;
        while (i < j) {
            while (i < j && nums[i++] < nums[right]) ;
            while (i < j && nums[j--] > nums[right]) ;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, i, right);
        return i;
    }

    public int getPivotMide(int[] nums, int left, int right) {
        if (right - left <= 5) {
            return insertSort(nums, left, right);
        }
        int currentLeft = left - 1;
        int m;
        for (int i = left; i + 4 < right; i += 5) {
            m = insertSort(nums, i, i + 4);
            swap(nums, ++currentLeft, m);
        }
        return getPivotMide(nums, left, currentLeft);
    }


    public int insertSort(int[] nums, int left, int right) {
        int k;
        for (int i = left + 1; i <= right; i++) {
            k = nums[i];
            int j = i - 1;
            while (j >= left && nums[j] > k) {
                nums[j + 1] = nums[j--];
            }
            nums[j + 1] = k;
        }
        return ((right - left) >> 1) + left;
    }


    public void swap(int nums[], int n, int m) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

}
