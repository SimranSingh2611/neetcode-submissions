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
