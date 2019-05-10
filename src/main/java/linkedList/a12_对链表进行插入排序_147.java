package linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * see https://leetcode-cn.com/problems/insertion-sort-list/
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class a12_对链表进行插入排序_147 {

    public static ListNode insertionSortList(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        ListNode ret = head;
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }

        for (int i = 0; i < listNodes.size(); i++) {
            int k = i;
            ListNode currentNode = listNodes.get(i);
            currentNode.next = null;
            while (k-- > 0) {
                ListNode listNode = listNodes.get(k);
                if (listNode.val < currentNode.val && k + 1 != i) {
                    listNode.next = currentNode;
                    currentNode.next = listNodes.get(k + 1);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(2);
        l2.next.next.next.next = new ListNode(1);

        ListNode listNode = insertionSortList(l2);
        System.out.println();
    }
}
