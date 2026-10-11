class Solution {
    // * TYPE: MINIMIZATION -- smallest speed finishing within h hours.
    // * BOUNDS: lo=0 (infeasible), hi=max(piles) (feasible); return hi.
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles)
            max = Math.max(max, pile);
        
        // System.out.println(max);

        // l = 0 = invalid
        int l = 0, r = max;

        while (l + 1 < r) {
            int mid = l + (r-l)/2;

            if (canFinishInHours(piles, mid, h))
                r = mid;
            else
                l = mid;
        }
        return r;
    }

    private boolean canFinishInHours(int[] piles, int speed, int maxHours) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + (long) speed - 1) / speed;
            if (hours > maxHours) {
                return false;
            }
        }
        return true;
    }
}
