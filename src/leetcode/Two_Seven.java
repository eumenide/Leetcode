package leetcode;

/**
 * @author eumes
 * @date 2018/10/10
 *
 *  Remove Element
 *  Description:
 *      Given an array nums and a value val, remove all instances of that
 *      value in-place and return the new length.
 *      Do not allocate extra space for another array, you must do this by
 *      modifying the input array in-place with O(1) extra memory.
 *  Example:
 *      Given nums = [3,2,2,3], val = 3
 *      Your function should return length = 2, with the first two elements of
 *      nums being 2.
 *      It doesn't matter what you leave beyond the returned length.
 */
public class Two_Seven {

    public static void main(String[] args){
        Two_Seven two_six = new Two_Seven();

        int[] nums = {3, 2, 2, 3, 4};
        int val = 3;

        int len = two_six.removeElement(nums, val);

        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }


    }

    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }

        int i = 0, j = 0;
        for (; j < nums.length; j++) {
            if (val != nums[j]) {
                nums[i++] = nums[j];
            }
        }

        return i;

    }

}
