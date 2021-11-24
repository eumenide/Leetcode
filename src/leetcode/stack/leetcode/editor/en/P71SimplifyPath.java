//Given a string path, which is an absolute path (starting with a slash '/') to 
//a file or directory in a Unix-style file system, convert it to the simplified 
//canonical path. 
//
// In a Unix-style file system, a period '.' refers to the current directory, a 
//double period '..' refers to the directory up a level, and any multiple 
//consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, 
//any other format of periods such as '...' are treated as file/directory names. 
//
// The canonical path should have the following format: 
//
// 
// The path starts with a single slash '/'. 
// Any two directories are separated by a single slash '/'. 
// The path does not end with a trailing '/'. 
// The path only contains the directories on the path from the root directory 
//to the target file or directory (i.e., no period '.' or double period '..') 
// 
//
// Return the simplified canonical path. 
//
// 
// Example 1: 
//
// 
//Input: path = "/home/"
//Output: "/home"
//Explanation: Note that there is no trailing slash after the last directory 
//name.
// 
//
// Example 2: 
//
// 
//Input: path = "/../"
//Output: "/"
//Explanation: Going one level up from the root directory is a no-op, as the 
//root level is the highest level you can go.
// 
//
// Example 3: 
//
// 
//Input: path = "/home//foo/"
//Output: "/home/foo"
//Explanation: In the canonical path, multiple consecutive slashes are replaced 
//by a single one.
// 
//
// Example 4: 
//
// 
//Input: path = "/a/./b/../../c/"
//Output: "/c"
// 
//
// 
// Constraints: 
//
// 
// 1 <= path.length <= 3000 
// path consists of English letters, digits, period '.', slash '/' or '_'. 
// path is a valid absolute Unix path. 
// 
// Related Topics String Stack 👍 979 👎 252


package leetcode.stack.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: eumes
 * @date: 2021-11-23 23:47:52
 * @title: Simplify Path
 */
public class P71SimplifyPath {
    
    public static void main(String[] args) {
        Solution_71 solution = new Solution_71();
        // TO TEST
        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/home//foo/"));
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_71 {
    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        Deque<String> deque = new ArrayDeque<>();

        for (String str : strings) {
            if ("..".equals(str)) {
                deque.pollFirst();
            } else if ("".equals(str) || ".".equals(str)) {
                continue;
            } else {
                deque.push(str);
            }
        }

        if (deque.isEmpty()) {
            return "/";
        }

        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append("/").append(deque.pollLast());
        }
        return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
