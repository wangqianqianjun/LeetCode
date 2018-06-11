/**
 * @wangqianjun
 * @create 2017-11-01 21:09
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 **/
public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray m = new MaximumSubarray();
        int[] A = new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        int[] B = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0};

        int l = m.findLength(A, B);
        System.out.println(l);
    }

    public int findLength(int[] A, int[] B) {
        int l1 = A.length, l2 = B.length, maxLength = 0, length = 1, p;
        Node[] temp = new Node[100];
        Node n, h;
        for (int i = 0; i < l1; i++) {
            if (temp[A[i]] == null) {
                temp[A[i]] = new Node(i);
            } else {
                h = temp[A[i]];
                n = new Node(i);
                while (h.next != null) {
                    h = h.next;
                }
                h.next = n;
            }
        }

        int index;
        for (int i = 0; i < l2; i++) {
            n = temp[B[i]];
            p = i;
            if (l2 - i + 1 < maxLength) break;
            while (n != null) {
                index = n.index;
                while (index + 1 < l1 && maxLength < l1 - n.index + 1 && p + 1 < l2 && A[++index] == B[++p]) length++;
                n = n.next;
                p = i;
                maxLength = maxLength > length ? maxLength : length;
                length = 1;
            }


        }
        return maxLength;
    }


    public int findLengthDP(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }


}


class Node {
    int index;
    Node next;

    Node(int index) {
        this.index = index;
    }
}