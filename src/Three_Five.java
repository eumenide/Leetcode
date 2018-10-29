import java.util.Arrays;

/**
 * @author eumes
 * @date 2018/10/29
 *
 *  Search Insert Position
 *  Description:
 *      Given a sorted array and a target value, return the index if the target
 *      is found. If not, return the index where it would be if it were inserted
 *      in order.
 *      You may assume no duplicates in the array.
 *  Example:
 *      Input: [1,3,5,6], 5
 *      Output: 2
 *      Input: [1,3,5,6], 2
 *      Output: 1
 *      Input: [1,3,5,6], 7
 *      Output: 4
 *      Input: [1,3,5,6], 0
 *      Output: 0
 */
public class Three_Five {

    public static void main(String[] args){
        Three_Five three_five = new Three_Five();

        int[] nums = {1, 3, 5, 6};
        int target = 7;

        System.out.println(three_five.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }

        return nums.length;

    }

}
