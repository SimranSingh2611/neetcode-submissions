/*
Classic Backtracking Problem
For a Backtracking Problem : Remember the 3 Parts
1. Choices
2. Constraints
3. Goal Condition

1. The Choices in this case is to either put a "(" or ")"
2. The Constraints are
   (a) -> The number of openBrackets or ClosedBrackets cannot be more than n
   (b) -> A ClosedBracket cannot be added to an empty string, i.e. a corresponding open bracket is needed
   (c) -> The count of closedBracket cannot be more than that of OpenBracket at any given time
3. The Goal Condition is when the length of the string becomes 2*n
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<>();
        backtrack(n, out, new StringBuilder(), 0, 0);
        return out;
    }

    private void backtrack(int n, List<String> out, StringBuilder sb, int openCount, int closedCount) {
        if (sb.length() == 2*n) {
            out.add(sb.toString());
        } else {
            if (openCount < n) {
                backtrack(n, out, sb.append("("), openCount+1, closedCount);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (closedCount < openCount) { 
                backtrack(n, out, sb.append(")"), openCount, closedCount+1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

            
    }


}
