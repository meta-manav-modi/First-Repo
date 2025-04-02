package stackQ1;

/** class Evaluate , helps to find the result of the expreesion 
 * and handelling all the operators according to their preferences
 */
public class Evaluate {
    /**method evaluate calculate the output of the expression
     * @param str
     * @return output of the string evaluation
     */
    public int evaluate(String str) {
        Stack<String> exp = new StackArr<>();
        Stack<Integer> nums = new StackArr<>();
        char[] ch = str.toCharArray();
        int i = 0;
        while (i < ch.length) {
            if (Character.isDigit(ch[i])) {
                int num = 0;
                while (i < ch.length && Character.isDigit(ch[i])) {
                    num = num * 10 + (ch[i] - '0');
                    i++;
                }
                nums.push(num);
                continue;
            }
            String curr = String.valueOf(ch[i]);

            if (i < ch.length - 1) {
                String twoChar = curr + ch[i + 1];
                if (expDual(twoChar)) {
                    curr = twoChar;
                    i++;
                }
            }

            if (curr.equals("(")) {
                exp.push(curr);
            }

            else if (curr.equals(")")) {
                while (!exp.isEmpty() && !exp.peek().equals("(")) {
                    int ans = calculate(nums, exp);
                    nums.push(ans);
                }
                exp.pop();
            }

            else if (opr(curr)) {
                while (!exp.isEmpty() && preference(curr) <= preference(exp.peek())) {
                    int ans = calculate(nums, exp);
                    nums.push(ans);
                }
                exp.push(curr);
            }
            i++;
        }

        while (!exp.isEmpty()) {
            int ans = calculate(nums, exp);
            nums.push(ans);
        }
        return nums.pop();
    }

    /** check the operator is present or not
     * @param curr
     * @return boolean value, curr is present or not
     */
    private boolean opr(String curr) {
        switch (curr) {
            case "||":
                return true;
            case "&&":
                return true;
            case "==":
                return true;
            case "!=":
                return true;
            case "<":
                return true;
            case ">":
                return true;
            case "<=":
                return true;
            case ">=":
                return true;
            case "+":
                return true;
            case "-":
                return true;
            case "*":
                return true;
            case "/":
                return true;
            case "^":
                return true;
            default:
                return false;
        }

    }
    
    private boolean expDual(String curr) {
        return curr.equals("==") || curr.equals("!=") ||
                curr.equals("<=") || curr.equals(">=") ||
                curr.equals("&&") || curr.equals("||");
    }

    /** method preference , gives the preference of an operator
     * @param operator
     * @return preference of that operator
     */
    private int preference(String op) {
        switch (op) {
            case "||":
                return 1;
            case "&&":
                return 2;
            case "==":
                return 3;
            case "!=":
                return 3;
            case "<":
                return 4;
            case ">":
                return 4;
            case "<=":
                return 4;
            case ">=":
                return 4;
            case "+":
                return 5;
            case "-":
                return 5;
            case "*":
                return 6;
            case "/":
                return 6;
            case "^":
                return 7;
            default:
                return -1;
        }
    }

    /** calculate the output of infix expression
     * @param nums
     * @param exp
     * @return output of infix exp
     */
    private int calculate(Stack<Integer> nums, Stack<String> exp) {

        int a = nums.pop();
        if (nums.isEmpty())
            return a;

        int b = nums.pop();
        String oprtor = exp.pop();

        switch (oprtor) {
            case "+":
                return b + a;
            case "-":
                return b - a;
            case "*":
                return b * a;
            case "/":
                return a == 0 ? 10020200 : b / a;
            case "^":
                return (int) Math.pow(b, a);
            case "<":
                return (b < a) ? 1 : 0;
            case ">":
                return (b > a) ? 1 : 0;
            case "<=":
                return (b <= a) ? 1 : 0;
            case ">=":
                return (b >= a) ? 1 : 0;
            case "==":
                return (b == a) ? 1 : 0;
            case "!=":
                return (b != a) ? 1 : 0;
            case "&&":
                return ((b != 0) && (a != 0)) ? 1 : 0;
            case "||":
                return ((b != 0) || (a != 0)) ? 1 : 0;
            default:
                return 0;
        }
    }
}
