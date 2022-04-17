package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eumes
 * @date 2018/7/19
 */
public class One {
    public static void main(String[] args){

    }

    public int[] twoSum_bruce(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length - 1; ++i){
            for(int j = i + 1; j < nums.length; ++j){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public int[] twoSum(int[] nums, int target) {
        // 记录访问到当前数字num时，需要达到target的另一个数字的位置
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int numNeed = target - nums[i];
            if (map.containsKey(numNeed)) {
                return new int[]{map.get(numNeed), i};
            }
            // 未找到，则将本次数字及对应位置放入map中
            map.put(nums[i], i);
        }

        return new int[0];
    }

}
