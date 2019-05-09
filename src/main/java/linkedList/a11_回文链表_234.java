package linkedList;

import java.util.Arrays;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class a11_回文链表_234 {

    public static void main(String[] args) {
        ListNode l2 = new ListNode(-1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(2);
        l2.next.next.next.next = new ListNode(-1);

        boolean palindrome = isPalindrome(l2);
        System.out.println(palindrome);
    }



    /**
     * 重写hash算法
     * 为什么只有11能通过?
     * 执行用时 : 3 ms, 在Palindrome Linked List的Java提交中击败了55.29% 的用户
     * 内存消耗 : 42.2 MB, 在Palindrome Linked List的Java提交中击败了91.53% 的用户
     */
    public static boolean isPalindrome(ListNode head) {
        int lhash = 0, rhash = 0;
        for(int x = 1; head != null; head = head.next, x *= 11) {
            lhash = lhash*11 + head.val;
            rhash = rhash + head.val*x;
        }
        return lhash == rhash;

    }

    /**
     * 快慢指针找出中间数, 翻转下半段比较
     * 执行用时 : 3 ms, 在Palindrome Linked List的Java提交中击败了55.10% 的用户
     * 内存消耗 : 43 MB, 在Palindrome Linked List的Java提交中击败了76.90% 的用户
     * 时间复杂度 : O(n)
     * 空间复杂度 ; O(1)
     */
    /*public static boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;
        // 是否总数是单数
        boolean isP = false;
        boolean ret = true;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        isP = fast.next != null;
        if (isP)
            slow = slow.next;

        // 翻转连表
        ListNode reverseHead = getReverse(slow);
        while (reverseHead != null) {
            if (reverseHead.val != head.val) {
                ret = false;
                break;
            }
            reverseHead = reverseHead.next;
            head = head.next;
        }

        return ret;
    }*/
    /**
     * 快慢指针找出中间数, 翻转下半段比较
     * 执行用时 : 1 ms, 在Palindrome Linked List的Java提交中击败了99.07% 的用户
     * 内存消耗 : 42.9 MB, 在Palindrome Linked List的Java提交中击败了79.14% 的用户
     * 时间复杂度 : O(n)
     * 空间复杂度 ; O(1)
     */
    /*public static boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        if(head.next.next==null){
            return head.val == head.next.val;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast.next!=null){
            if(slow.val == fast.next.val){
                if(fast.next.next!=null){
                    return false;
                }
                fast.next = null;
                slow = slow.next;
                fast = slow.next;
                if(fast==null || slow.val == fast.val){
                    return true;
                }
            }else{
                fast = fast.next;
            }
        }
        return false;
    }*/

    /**
     * 执行用时 : 9 ms, 在Palindrome Linked List的Java提交中击败了13.43% 的用户
     * 内存消耗 : 48.4 MB, 在Palindrome Linked List的Java提交中击败了5.03% 的用户
     * 时间复杂度 : O(n)
     * 空间复杂度 ; O(n)
     */
    /*public boolean isPalindrome(ListNode head) {
        int[] array = new int[100000];
        int count = 0;
        while (head != null) {
            array[count++] = head.val;
            head = head.next;
        }

        boolean ret = true;
        int[] ints = Arrays.copyOf(array, count);
        for (int i = 0; i < count / 2; i++) {
            if (ints[i] != ints[count - 1 -i]) {
                ret = false;
                break;
            }

        }
        return ret;
    }*/

}
