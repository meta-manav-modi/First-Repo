package molecule;

import java.util.Map;
import java.util.Stack;

/** class MoleculeMass, used to calculate the atmonic mass of formula */
public class MoleculeMass {
    private static Map<Character, Integer> atomicMass = Map.of(
            'C', 12,
            'O', 16,
            'H', 1);
    Stack<Integer> stack = new Stack<>();

    /** method used to calculate atmoc mass of formula using stack
     * @ return total atmoic mass
     * @param String input
     */
    public int getTotalmass(String input) {
        int index = 0;

        while (index < input.length()) {
            char ch = input.charAt(index);

            if ( Character.isDigit(input.charAt(0 ))) {
                throw new AssertionError("Wrong formula");
            }
            if ( Character.isDigit(input.charAt(index )) && 
            (input.charAt( index - 1) == '(') )  {
                throw new AssertionError("Wrong formula");
            }

            if (atomicMass.containsKey(ch)) {
                stack.push(atomicMass.get(ch));
                int count = 1;
                if (index + 1 < input.length() && Character.isDigit(input.charAt(index + 1))) {
                    count = Character.getNumericValue(input.charAt(index + 1));
                    index++;
                }
                index++;
                int lastData = stack.pop();
                stack.push(lastData * count);
            } else if (ch == '(') {
                stack.push(-1);
                index++;
            } else if (ch == ')') {
                int count = 1;
                if (index + 1 < input.length() && Character.isDigit(input.charAt(index + 1))) {
                    count = Character.getNumericValue(input.charAt(index + 1));
                    index++;
                }
                index++;
                int groupMass = 0;
                while (stack.peek() != -1) {
                    groupMass += stack.pop();
                }
                stack.pop();
                stack.push(groupMass * count);
            }
        }
        int totalMass = 0;
        while (!stack.isEmpty()) {
            totalMass += stack.pop();
        }
        return totalMass;
    }
}
