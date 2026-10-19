class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int a,b;
        for(String token : tokens) {
            if (token.equals("+")) {
                a = s.pop();
                b = s.pop();
                s.push(a+b);
            } else if(token.equals("-")) {
                a = s.pop();
                b = s.pop();
                s.push(b-a);
            } else if(token.equals("*")) {
                a = s.pop();
                b = s.pop();
                s.push(a*b);
            } else if(token.equals("/")) {
                a = s.pop();
                b = s.pop();
                s.push(b/a);
            } else {
                s.add(Integer.parseInt(token));
            }
        }
        return s.pop();
    }
}
