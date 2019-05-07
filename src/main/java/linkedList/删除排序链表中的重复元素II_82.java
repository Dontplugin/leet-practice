package linkedList;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class 删除排序链表中的重复元素II_82 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode ret = new ListNode(Integer.MIN_VALUE);
        ListNode ok = new ListNode(Integer.MIN_VALUE);
        ret.next = head;
        ok.next = ret;
        ListNode last = ret;
        ListNode lastL = ok;
        // 开始删除节点的标志
        boolean isDelete = false;
        while (head != null) {
            if (last.val != head.val) {
                if (isDelete) {
                    lastL.next = head;
                    last = lastL.next;
                    isDelete = false;
                }
                else {
                    last = last.next;
                    lastL = lastL.next;
                }
            } else {
                isDelete = true;
            }

            head = head.next;

        }
        if (isDelete) {
            lastL.next = head;
        }
        return ret.next;
    }

    public static void main(String[] args) {
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(1);

        ListNode listNode = deleteDuplicates(l2);
        System.out.println();
    }
}
