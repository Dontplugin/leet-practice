package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class a1_两数之和_1 {


    /**
     * 用map记录之前的数据, 时间复杂度为O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key))
                return new int[]{map.get(key), i};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 执行用时 : 31 ms, 在Two Sum的Java提交中击败了54.50% 的用户
     * 内存消耗 : 36.6 MB, 在Two Sum的Java提交中击败了94.39% 的用户
     */
    /*public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        int size1 = nums.length;
        for (int i = 0; i < size1; i++) {
            for (int j = i + 1; j < size1; j++) {
                int i1 = target - nums[i];
                if (i1)
                if (target - nums[i] == nums[j]) {
                    ret[0] = i;
                    ret[1] = j;
                    break;
                }

            }
        }

        return ret;
    }*/
}
