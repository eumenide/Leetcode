//You are visiting a farm that has a single row of fruit trees arranged from 
//left to right. The trees are represented by an integer array fruits where fruits[i]
// is the type of fruit the iᵗʰ tree produces. 
//
// You want to collect as much fruit as possible. However, the owner has some 
//strict rules that you must follow: 
//
// 
// You only have two baskets, and each basket can only hold a single type of 
//fruit. There is no limit on the amount of fruit each basket can hold. 
// Starting from any tree of your choice, you must pick exactly one fruit from 
//every tree (including the start tree) while moving to the right. The picked 
//fruits must fit in one of your baskets. 
// Once you reach a tree with fruit that cannot fit in your baskets, you must 
//stop. 
// 
//
// Given the integer array fruits, return the maximum number of fruits you can 
//pick. 
//
// 
// Example 1: 
//
// 
//Input: fruits = [1,2,1]
//Output: 3
//Explanation: We can pick from all 3 trees.
// 
//
// Example 2: 
//
// 
//Input: fruits = [0,1,2,2]
//Output: 3
//Explanation: We can pick from trees [1,2,2].
//If we had started at the first tree, we would only pick from trees [0,1].
// 
//
// Example 3: 
//
// 
//Input: fruits = [1,2,3,2,2]
//Output: 4
//Explanation: We can pick from trees [2,3,2,2].
//If we had started at the first tree, we would only pick from trees [1,2].
// 
//
// 
// Constraints: 
//
// 
// 1 <= fruits.length <= 10⁵ 
// 0 <= fruits[i] < fruits.length 
// 
// Related Topics Array Hash Table Sliding Window 👍 919 👎 69


package leetcode.dp.editor.en;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: eumes
 * @date: 2022-04-11 00:18:34
 * @title: Fruit Into Baskets
 */
public class P904FruitIntoBaskets {
    
    public static void main(String[] args) {
        Solution_904 solution = new Solution_904();
        // TO TEST
        
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_904 {
    public int totalFruit(int[] fruits) {
        // 1，2，1，3，2，3
        // [i,j] is the sliding window, and it's the current longest window.
        //Suppose we found current longest window [i, j], then this length will be kept, because,
        //as j++, if the sliding window contains more than 2, then also we will do i++, so that is to say, the
        // current longest length will be kept the same,
        //in another word, when [i,j] reached a maximum, it will not become smaller
        //on the other side, when j++, if the current window contains less than two, then i will not increase(because
        // the if statement), in this way, the longest length of sliding window will get updated
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        for (; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            if (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                map.remove(fruits[left++], 0);
            }
        }

        return right - left;
    }

    public int totalFruit_1(int[] fruits) {
        // 存储当前窗口中类型及数量
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        for (; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            // 当超过2种类型时，移动左指针，直到移除一种类型
            while (map.size() > 2) {
                if (map.get(fruits[left]) == 1) {
                    map.remove(fruits[left]);
                } else {
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                }
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
