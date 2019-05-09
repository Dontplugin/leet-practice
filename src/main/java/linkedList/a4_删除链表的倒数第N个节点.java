package linkedList;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class a4_删除链表的倒数第N个节点 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ret = head;
        ListNode myHead = head;
        ListNode last = head;
        int count = 0;
        while (head.next != null) {
            head = last;
            head = head.next;
            count++;
            if (count > n - 1) {
                myHead = myHead.next;
                count--;
            }
        }

        last.next = last.next.next;
        return ret;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode listNode = removeNthFromEnd(head, 3);
        System.out.println();
    }
}
