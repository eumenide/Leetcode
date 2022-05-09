//Koko loves to eat bananas. There are n piles of bananas, the iᵗʰ pile has 
//piles[i] bananas. The guards have gone and will come back in h hours. 
//
// Koko can decide her bananas-per-hour eating speed of k. Each hour, she 
//chooses some pile of bananas and eats k bananas from that pile. If the pile has less 
//than k bananas, she eats all of them instead and will not eat any more bananas 
//during this hour. 
//
// Koko likes to eat slowly but still wants to finish eating all the bananas 
//before the guards return. 
//
// Return the minimum integer k such that she can eat all the bananas within h 
//hours. 
//
// 
// Example 1: 
//
// 
//Input: piles = [3,6,7,11], h = 8
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: piles = [30,11,23,4,20], h = 5
//Output: 30
// 
//
// Example 3: 
//
// 
//Input: piles = [30,11,23,4,20], h = 6
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= piles.length <= 10⁴ 
// piles.length <= h <= 10⁹ 
// 1 <= piles[i] <= 10⁹ 
// 
// Related Topics Array Binary Search 👍 4092 👎 184


package leetcode.editor.en;

/**
 * Koko Eating Bananas
 * 
 * @author: eumes
 * @date: 2022-05-09 23:41:08
 */
 public class P875KokoEatingBananas {
    public static void main(String[] args) {
//        Solution_P875 solution = new Solution_P875();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P875 {
    public int minEatingSpeed(int[] piles, int h) {
        int le = 1, ri = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            ri = Math.max(ri, piles[i]);
        }

        ri++;
        // 找最边界，即k最小值
        while (le < ri) {
            int mid = le + ((ri - le) >> 1);
            int curH = findH(mid, piles);
            if (curH > h) {
                // 当前h比给定的h大，说明k取小了，可以扩大
                le = mid + 1;
            } else {
                // 当前h比给定的h小，说明k取大了，需要缩小
                ri = mid;
            }
        }

        return le;
    }

    private int findH(int k, int[] piles) {
        int h = 0;
        for (int i = 0; i < piles.length; i++) {
            h += (piles[i] - 1) / k + 1;
        }

        return h;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
