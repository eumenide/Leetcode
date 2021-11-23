//The school cafeteria offers circular and square sandwiches at lunch break, 
//referred to by numbers 0 and 1 respectively. All students stand in a queue. Each 
//student either prefers square or circular sandwiches. 
//
// The number of sandwiches in the cafeteria is equal to the number of students.
// The sandwiches are placed in a stack. At each step: 
//
// 
// If the student at the front of the queue prefers the sandwich on the top of 
//the stack, they will take it and leave the queue. 
// Otherwise, they will leave it and go to the queue's end. 
// 
//
// This continues until none of the queue students want to take the top 
//sandwich and are thus unable to eat. 
//
// You are given two integer arrays students and sandwiches where sandwiches[i] 
//is the type of the ith sandwich in the stack (i = 0 is the top of the stack) 
//and students[j] is the preference of the jth student in the initial queue (j = 0 
//is the front of the queue). Return the number of students that are unable to eat. 
//
//
// 
// Example 1: 
//
// 
//Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
//Output: 0 
//Explanation:
//- Front student leaves the top sandwich and returns to the end of the line 
//making students = [1,0,0,1].
//- Front student leaves the top sandwich and returns to the end of the line 
//making students = [0,0,1,1].
//- Front student takes the top sandwich and leaves the line making students = [
//0,1,1] and sandwiches = [1,0,1].
//- Front student leaves the top sandwich and returns to the end of the line 
//making students = [1,1,0].
//- Front student takes the top sandwich and leaves the line making students = [
//1,0] and sandwiches = [0,1].
//- Front student leaves the top sandwich and returns to the end of the line 
//making students = [0,1].
//- Front student takes the top sandwich and leaves the line making students = [
//1] and sandwiches = [1].
//- Front student takes the top sandwich and leaves the line making students = [
//] and sandwiches = [].
//Hence all students are able to eat.
// 
//
// Example 2: 
//
// 
//Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= students.length, sandwiches.length <= 100 
// students.length == sandwiches.length 
// sandwiches[i] is 0 or 1. 
// students[i] is 0 or 1. 
// 
// Related Topics Array Stack Queue Simulation 👍 560 👎 34


package leetcode.stack.leetcode.editor.en;

/**
 * @author: eumes
 * @date: 2021-11-23 23:25:16
 * @title: Number of Students Unable to Eat Lunch
 */
public class P1700NumberOfStudentsUnableToEatLunch {
    
    public static void main(String[] args) {
        Solution_1700 solution = new Solution_1700();
        // TO TEST 1
        System.out.println(solution.countStudents(new int[] {1, 1, 0, 0}, new int[] {0, 1, 0, 1}));

        // Test 2
        System.out.println(solution.countStudents(new int[] {1, 1, 1, 0, 0, 1}, new int[] {1, 0, 0, 0, 1, 1}));
        
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] num = {0, 0};
        for (int s : students) {
            num[s]++;
        }

        for (int sandwich : sandwiches) {
            if (num[sandwich] == 0) {
                break;
            }
            num[sandwich]--;
        }

        return num[0] + num[1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
