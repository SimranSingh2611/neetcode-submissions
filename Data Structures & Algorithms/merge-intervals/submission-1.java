class Solution {
    public int[][] merge(int[][] intervals) {
        // Questions to interviewer:
        //   1. intervals sorted or not.
        //   2. [1,4][4,7] can be merged into [1,7] or not.

        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // always add the first interval
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int prevEnd = ans.get(ans.size() - 1)[1];
            int curStart = intervals[i][0];
             //comparing the values of prevEnd and curStart
            if (curStart <= prevEnd) {
                //do the merging
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            } else {
                // just add the interval
                ans.add(intervals[i]);
            }
        }
        int[][] res = new int[ans.size()][2];
        ans.toArray(res);
        return res;
    }
}
