//There are n different online courses numbered from 1 to n. You are given an 
//array courses where courses[i] = [durationi, lastDayi] indicate that the iᵗʰ 
//course should be taken continuously for durationi days and must be finished before 
//or on lastDayi. 
//
// You will start on the 1ˢᵗ day and you cannot take two or more courses 
//simultaneously. 
//
// Return the maximum number of courses that you can take. 
//
// 
// Example 1: 
//
// 
//Input: courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
//Output: 3
//Explanation: 
//There are totally 4 courses, but you can take 3 courses at most:
//First, take the 1ˢᵗ course, it costs 100 days so you will finish it on the 100
//ᵗʰ day, and ready to take the next course on the 101ˢᵗ day.
//Second, take the 3ʳᵈ course, it costs 1000 days so you will finish it on the 1
//100ᵗʰ day, and ready to take the next course on the 1101ˢᵗ day. 
//Third, take the 2ⁿᵈ course, it costs 200 days so you will finish it on the 130
//0ᵗʰ day. 
//The 4ᵗʰ course cannot be taken now, since you will finish it on the 3300ᵗʰ 
//day, which exceeds the closed date.
// 
//
// Example 2: 
//
// 
//Input: courses = [[1,2]]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: courses = [[3,2],[4,3]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= courses.length <= 10⁴ 
// 1 <= durationi, lastDayi <= 10⁴ 
// 
// Related Topics Array Greedy Heap (Priority Queue) 👍 2792 👎 76


package leetcode.editor.en;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Course Schedule III
 * 
 * @author: eumes
 * @date: 2022-06-24 00:09:58
 */
 public class P630CourseScheduleIii {
    public static void main(String[] args) {
//        Solution_P630 solution = new Solution_P630();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P630 {
    public int scheduleCourse_priorityQueue(int[][] courses) {
        // 按截至时间排序
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        // 大顶堆，存储耗时
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        int totalTime = 0;
        for (int[] course : courses) {
            totalTime += course[0];
            heap.offer(course[0]);
            // 如果当前总耗时 > course的DDL，说明安排不合理，此时去除之前耗时最大的课程
            if (totalTime > course[1]) {
                totalTime -= heap.poll();
            }
        }

        return heap.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
