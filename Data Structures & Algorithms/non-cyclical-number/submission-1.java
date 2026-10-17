class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hs = new HashSet<>();

        while (true) {
            int sum = 0;

            while (n > 0) {
                int d = n % 10;
                sum += d * d;
                n /= 10;
            }

            if (sum == 1)
                return true;

            if (!hs.add(sum))
                return false;

            n = sum;
        }
    }
}
