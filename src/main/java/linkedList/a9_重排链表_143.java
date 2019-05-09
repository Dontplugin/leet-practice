package linkedList;


import java.util.LinkedList;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class a9_重排链表_143 {

    /**
     * 执行用时 : 582 ms, 在Reorder List的Java提交中击败了7.23% 的用户
     * 内存消耗 : 46 MB, 在Reorder List的Java提交中击败了44.41% 的用户
     * @param head
     */
    public static void reorderList(ListNode head) {
        ListNode cur = head;

        LinkedList<ListNode> list = new LinkedList<ListNode>();
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        cur = head;
        int count = list.size();
        for (int i = 0; i < count / 2; i++) {
            ListNode temp2 = list.get(count - 1 - i);
            ListNode ok = list.get(count - 2 - i);
            ok.next = null;
            ListNode temp = cur.next;
            cur.next = temp2;
            temp2.next = temp;
            cur = cur.next.next;
        }

    }

    /**
     * 执行用时 : 3 ms, 在Reorder List的Java提交中击败了95.44% 的用户
     * 内存消耗 : 39.2 MB, 在Reorder List的Java提交中击败了95.21% 的用户
     */
    /*public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverseList(slow.next);
        slow.next = null;
        ListNode res = head;
        while (newHead != null) {
            ListNode next = newHead.next;
            ListNode next1 = res.next;
            newHead.next = res.next;
            res.next = newHead;
            newHead = next;
            res = next1;
        }
    }
    // 递归的逆转链表
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }*/

    static class DoubleNode {
        int val;
        DoubleNode next;
        DoubleNode pre;
        DoubleNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(4);
        l2.next.next.next.next = new ListNode(5);
        l2.next.next.next.next.next = new ListNode(6);

        reorderList(l2);
        System.out.println();
        System.out.println();
    }

}
