package com.mrdios.competencymatrix.leetcode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目地址
 * https://leetcode-cn.com/problems/two-sum
 * <p>
 * 题目描述
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author huxiong
 * @date 2020-07-23
 */
public class Easy_001_TwoSum {

    /**
     * 算法关键点:
     * <li>求和转换为求差</li>
     * <li>借助 Map 结构将数组中每个元素及其索引相互对应</li>
     * <li>以空间换时间，将查找时间从 O(N) 降低到 O(1)</li>
     *
     * @param nums   目标整型数组
     * @param target 目标整型值
     * @return 目标数组中和等于目标值的元素的下标数组
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        // 目标数组元素和下标的映射
        Map<Integer, Integer> numIndexMap = new HashMap<>(nums.length);
        // 目标值与当前元素之差
        int diff;
        for (int i = 0; i < nums.length; i++) {
            // 第一次循环只放入第一个数组元素的映射关系
            if (i == 0) {
                numIndexMap.put(nums[i], i);
                continue;
            }
            // 第二次循环开始在映射表中查找有无与数组当前元素之和等于目标数的
            diff = target - nums[i];
            // 如果映射表中包含了这个差值,说明在数组中找到了两个和为目标数的元素,返回
            if (numIndexMap.containsKey(diff)) {
                result[0] = numIndexMap.get(diff);
                result[1] = i;
                return result;
            }
            // 未找到时放入映射关系,为下一次循环做准备
            numIndexMap.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
