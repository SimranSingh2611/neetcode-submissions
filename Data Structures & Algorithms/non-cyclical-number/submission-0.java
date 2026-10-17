class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hs = new HashSet<>();
        int sum = 0;
        boolean flag = true;
        while(flag) {
            while (n > 0) {
                int d = n%10;
                sum += (d*d);
                n /= 10;
            }
            // System.out.println(sum);
            if (!hs.add(sum))
                return false;
            else {
                if (sum == 1)
                    return true;
                n = sum;
                sum = 0;
                flag = true;
            }
        }
        return true;
    }
}
