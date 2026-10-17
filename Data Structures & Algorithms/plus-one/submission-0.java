class Solution {
    public int[] plusOne(int[] digits) {

        int n = digits.length;
        int carry = 0;
        List<Integer> out = new ArrayList<>();
        for(int i=n-1; i>=0; i--) {
            int sum = 0;
            if (i == n-1)
                sum = digits[i] + carry + 1;
            else
                sum = digits[i] + carry;
            int d = sum%10;
            carry = sum / 10;
            out.add(d);
        }
        if (carry != 0)
            out.add(carry);
        // System.out.println(out);

        int[] ans = new int[out.size()];
        for(int i=0; i<ans.length; i++) {
            ans[i] = out.get(out.size()-i-1);
        }
        return ans;
    }
}
