import java.util.HashMap;
import java.util.Stack;

/**
 * @author eumes
 * @date 2018/10/8
 * <p>
 * Description:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */
public class Two_Zero {

    private HashMap<Character, Character> mappings = new HashMap<>();

    public Two_Zero() {
        this.mappings.put(')', '(');
        this.mappings.put(']', '[');
        this.mappings.put('}', '{');
    }

    public static void main(String[] args) {
        String s = "([{])";

        Two_Zero two_zero = new Two_Zero();

        System.out.println(two_zero.isValid(s));
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        if (s != null) {
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (this.mappings.containsKey(ch)) {
                    char topChar = stack.empty() ? '*' : stack.pop();
                    if (topChar != this.mappings.get(ch)) {
                        return false;
                    }
                }else {
                    stack.push(ch);
                }
            }
        }

        return stack.empty();
    }

}
