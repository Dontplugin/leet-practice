package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class a2_寻找两个有序数组的中位数_4 {

    public static void main(String[] args) {
        int[] num1 = new int[]{3};
        int[] num2 = new int[]{-2,-1};
//        double medianSortedArrays = findMedianSortedArrays(num1, num2);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num2.length; i++) {
            list.add(num2[i]);
        }
        getInsertIndex(list, 5);
        System.out.println();

    }

    /**
     * 问题简化成小数组中的数字从大到下插入另一个数组, 知道插入的下标等于中位数的坐标为止
     * <p>
     * 执行用时 : 47 ms, 在Median of Two Sorted Arrays的Java提交中击败了56.45% 的用户
     * 内存消耗 : 46.3 MB, 在Median of Two Sorted Arrays的Java提交中击败了96.21% 的用户
     *
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return getMiddle(nums1, nums2);
        } else {
            return getMiddle(nums2, nums1);
        }
    }

    private static double getMiddle(int[] nums1, int[] nums2) {
        // 是否是单数
        boolean isOk = (nums1.length + nums2.length) % 2 == 1;
        int index = (nums1.length + nums2.length) / 2;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }

        // 上一次插入的位置
        int lastIndex = 0;
        int size = nums2.length;
        for (int i = 0; i < size; i++) {
            lastIndex = getInsertIndex(list,nums2[i]);
            if (lastIndex > index) {
                break;
            }
        }

        return isOk ? list.get(index) : ((double) list.get(index) + (double) list.get(index - 1)) / 2;
    }

    /**
     * 二分查找插入
     */
    private static int getInsertIndex(List<Integer> list, int target) {
        int size = list.size();
        int start = 0, end = size - 1;
        int lastMiddle = -5;
        int middle = -1;
        while (size > 0) {
             middle = (start + end) / 2;

            int compare = list.get(middle).compareTo(target);
            if (Math.abs(lastMiddle - middle) == 1) {
                int step = compare < 0 ? 1 : 0;
                middle = middle + step;
                break;
            } else if (compare > 0) {
                end = middle;
            } else {
                start = middle;
            }
            lastMiddle = middle;
            size /= 2;
        }
        list.add(middle, target);
        return middle;
    }
}
