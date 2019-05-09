package linkedList;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class a5_合并两个有序链表_21 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 超时解法
     * @param l1
     * @param l2
     * @return
     */
    /*public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        head.next = l1;
        ListNode last = head;

        while (l2 != null) {

            while (l1 != null) {
                int v1 = l1.val;
                int v2 = l2.val;

                if (v1 < v2) {
                    last = l1;
                    if (l1.next == null) {
                        l1.next = l2;
                        break;
                    } else {
                        l1 = l1.next;
                    }
                } else {
                    ListNode one = new ListNode(l2.val);
                    last.next = one;
                    one.next = l1;
                    last = last.next;
                    l2 = l2.next;
                    break;
                }
            }

        }

        return head.next;
    }*/

    /**
     * 时间复杂度较高实现
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return head.next;
    }

    /**
     * 时间复杂度较小实现
     * @param l1
     * @param l2
     * @return
     */
    /*public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }*/

    /**
     * [-2,5]
     * [-9,-6,-3,-1,1,6]
     *
     * [-9,-6,-3,-2,-1,1,5,6]
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(-2);
        l1.next = new ListNode(5);


        ListNode l2 = new ListNode(-9);
        l2.next = new ListNode(-6);
        l2.next.next = new ListNode(-3);
        l2.next.next.next = new ListNode(-1);
        l2.next.next.next.next = new ListNode(1);
        l2.next.next.next.next.next = new ListNode(6);

        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println();
    }
}
