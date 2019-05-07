package linkedList;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class 旋转链表_61 {

    public static ListNode rotateRight(ListNode head, int k) {
        ListNode first = head;
        if (head == null)
            return null;

        int len = 1;
        while (head.next != null) {
            len++;
            head = head.next;
        }
        head.next = first;

        // 需要向右
        int move = len - k;
        while (move < 0) {
            move = move + len;
        }

        ListNode broke = null;
        while (move > 0) {
            move--;
            if (move == 0)
                broke = first;
            first = first.next;
        }

        broke.next = null;

        return first;

    }

    public static void main(String[] args) {

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(4);
        l2.next.next.next.next = new ListNode(5);
        l2.next.next.next.next.next = new ListNode(6);
        rotateRight(l2, 1);
        System.out.println();
    }
}
