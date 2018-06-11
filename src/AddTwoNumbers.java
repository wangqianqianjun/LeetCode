/**
 * Created by wqj on 2017/10/26.
 * <p>
 * Letcode
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);

        ListNode l2 = new ListNode(0);

        AddTwoNumbers a = new AddTwoNumbers();

        ListNode n = a.addTwoNumbers(l1, l2);

        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = new ListNode(0);
        int value, radix = 0;
        ListNode n = head;
        ListNode temp;
        while (l1 != null || l2 != null) {
            value = 0;
            if (l1 != null) {
                value += l1.val;
            }
            if (l2 != null) {
                value += l2.val;
            }
            if (radix == 1) {
                value += 1;
            }
            if (value / 10 > 0) {
                radix = 1;
            } else {
                radix = 0;
            }
            temp = new ListNode(value % 10);
            n.next = temp;
            n = n.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (radix == 1) {
            n.next = new ListNode(1);
        }

        return head.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}