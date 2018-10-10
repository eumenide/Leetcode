/**
 * @author eumes
 * @date 2018/10/10
 *
 *  Remove Duplicates from Sorted Array
 *  Description:
 *      Given a sorted array nums, remove the duplicates in-place such that
 *      each element appear only once and return the new length. Do not
 *      allocate extra space for another array, you must do this by modifying
 *      the input array in-place with O(1) extra memory.
 *  Example:
 *      Given nums = [1,1,2],
 *      Your function should return length = 2, with the first two elements of
 *      nums being 1 and 2 respectively.
 *      It doesn't matter what you leave beyond the returned length.
 */
public class Two_Six {

    public static void main(String[] args){
        Two_Six two_six = new Two_Six();

        int[] nums = {1, 1, 2};

        int len = two_six.removeDuplicates(nums);

        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }


    }

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int i = 0, j = 1;
        for (; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }

        return i + 1;

    }

}
