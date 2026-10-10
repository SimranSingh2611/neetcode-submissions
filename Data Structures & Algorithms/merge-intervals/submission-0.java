class Solution {
    public int[][] merge(int[][] intervals) {

        // Questions to interviewer:
        //   1. intervals sorted or not.
        //   2. [1,4][4,7] can be merged into [1,7] or not.

        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> out = new ArrayList<>();
        // always add the first interval
        out.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int prevEnd = out.get(out.size()-1)[1];
            int currStart = intervals[i][0];

            if (currStart <= prevEnd) {
                // intervals can be merged. So merge them.
                out.get(out.size()-1)[1] = Math.max(out.get(out.size() - 1)[1], intervals[i][1]);
            } else {
                out.add(intervals[i]);
            }
        }

        int[][] res = new int[out.size()][2];
        out.toArray(res);
        return res;
        
    }
}
