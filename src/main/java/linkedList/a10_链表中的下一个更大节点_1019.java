package linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i)
 * 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 *
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 *
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 *
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * 示例 3：
 *
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 */
public class a10_链表中的下一个更大节点_1019 {

    public static void main(String[] args) {
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(7);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(3);
        l2.next.next.next.next = new ListNode(5);
        System.out.println(nextLargerNodes(l2));
    }

    // 使用 monotonic stack 解决此类问题。
    public static int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        // 1. 创建一个容器 list 来存储数据
        ArrayList<Integer> list = new ArrayList<>();
        int size = 0;
        while (head != null) {
            list.add(head.val);
            size++;
            head = head.next;
        }
        // 2. 创建一个栈 stack ，这个栈里面存储的是对应位置的 list 元素及其之后元素中最大的值。
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[size];
        // 3. 在 list 中从右往左遍历，stack 中凡是比 list.get(i) 小的都 pop 出去，
        // 这样 stack 剩下的元素都是比 list.get(i) 更大的元素。
        for (int i = list.size() - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= list.get(i)) {
                stack.pop();
            }
            ans[i] = stack.empty() ? 0 : stack.peek();
            stack.push(list.get(i));
        }
        return ans;
    }
    /*public static int[] nextLargerNodes(ListNode head) {
        int[] stack = new int[10000];
        int[] res = new int[10000];
        int[] temp = new int[10000];
        int top = -1, i = 0;
        ListNode node = head;
        while (node != null) {
            while (top != -1 && temp[stack[top]] < node.val)
                res[stack[top--]] = node.val;
            stack[++top] = i;
            temp[i++] = node.val;
            node = node.next;
        }
        return Arrays.copyOf(res, i);
    }*/
    /**
     * 执行用时 : 130 ms, 在Next Greater Node In Linked List的Java提交中击败了34.18% 的用户
     * 内存消耗 : 39.6 MB, 在Next Greater Node In Linked List的Java提交中击败了100.00% 的用户
     * @param head
     * @return
     */
    /*public static int[] nextLargerNodes(ListNode head) {
        int[] temp = new int[10000];
        int count = 0;
        while (head != null) {
            temp[count++] = head.val;
            head = head.next;
        }

        int[] ret = new int[count];
        for (int i = 0; i < count; i++) {
            ret[i] = getLarger(temp, count, i);
        }

        return ret;
    }

    public static int getLarger(int[] all, int size, int target) {
        int value = all[target];
        for (int i = target + 1; i < size; i++) {
            int nextValue = all[i];
            if (nextValue > value) {
                return nextValue;
            }
        }
        return 0;

    }*/

    // 超时
    /*public static int[] nextLargerNodes(ListNode head) {

        List<Integer> list = new ArrayList<>();
        ListNode cur = head;

        while (head != null) {
            int value = head.val;
            while (cur.next != null) {
                int nextValue = cur.next.val;
                if (nextValue > value) {
                    list.add(nextValue);
                    break;
                }
                cur = cur.next;
            }

            if (cur.next == null)
                list.add(0);

            head = head.next;
            cur = head;
        }

        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }*/

}
