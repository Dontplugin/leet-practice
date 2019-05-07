package linkedList;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class 删除排序链表中的重复元素_83 {

    /**
     * 执行用时 : 8 ms, 在Remove Duplicates from Sorted List的Java提交中击败了5.56% 的用户
     * 内存消耗 : 37.2 MB, 在Remove Duplicates from Sorted List的Java提交中击败了52.70% 的用户
     * @param head
     * @return
     */
    /*public static ListNode deleteDuplicates(ListNode head) {
        ListNode ret = new ListNode(0);
        ret.next = head;

        ListNode lastNode = ret;

        Set<Integer> stringSet = new HashSet<Integer>(8);
        while (head != null) {

            if (stringSet.contains(head.val)) {
                lastNode.next = head.next;
                head = lastNode.next;
            } else {
                stringSet.add(head.val);
                lastNode = head;
                head = head.next;
            }
        }

        return ret.next;

    }*/

    /**
     * 执行用时 : 2 ms, 在Remove Duplicates from Sorted List的Java提交中击败了69.88% 的用户
     * 内存消耗 : 36.1 MB, 在Remove Duplicates from Sorted List的Java提交中击败了83.72% 的用户
     * @param head
     * @return
     */
    /*public static ListNode deleteDuplicates(ListNode head) {
        ListNode ret = new ListNode(Integer.MIN_VALUE);
        ret.next = head;
        int lastValue = ret.val;
        ListNode lastNode = ret;
        while (head != null) {

            if (lastValue == head.val) {
                lastNode.next = head.next;
                head = lastNode.next;
            } else {
                lastValue = head.val;
                lastNode = head;
                head = head.next;
            }
        }
        return ret.next;

    }*/

    /**
     * 执行用时 : 1 ms, 在Remove Duplicates from Sorted List的Java提交中击败了98.77% 的用户
     * 内存消耗 : 35.8 MB, 在Remove Duplicates from Sorted List的Java提交中击败了95.71% 的用户
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val) head = head.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(1);

        ListNode listNode = deleteDuplicates(l2);
        System.out.println();
    }
}
