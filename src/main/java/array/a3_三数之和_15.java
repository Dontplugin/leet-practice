package array;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class a3_三数之和_15 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println();
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int num : nums) {
            list.add(num);
        }
        for (int i = 0; i < list.size(); i++) {

            Integer v1 = list.get(i);
            int target = 0 - v1;
            twoSum(set, list, target, i);
        }
        if (set.size() > 0) {
            for (String each : set) {
                String[] split = each.split(",");
                List<Integer> temp = new ArrayList<>();
                temp.add(Integer.parseInt(split[0]));
                temp.add(Integer.parseInt(split[1]));
                temp.add(Integer.parseInt(split[2]));
                ret.add(temp);
            }
        }

        return ret;
    }

    /**
     * 用map记录之前的数据, 时间复杂度为O(n)
     */
    public static void twoSum(Set<String> ret, List<Integer> nums, int target, int startIndex) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.size();
        for (int i = startIndex + 1; i < length; i++) {
            int key = target - nums.get(i);
            if (map.containsKey(key)) {
                ret.add(nums.get(startIndex) + "," +key + "," + nums.get(i));
            }
            map.put(nums.get(i), i);
        }
    }
}
