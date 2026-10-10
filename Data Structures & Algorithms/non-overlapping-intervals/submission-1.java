class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int ctr = 0;
        int prevEnd = intervals[0][1];
        int len = intervals.length;

        for(int i=1; i<len; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currStart < prevEnd) {
                // overlap
                ctr++;
                // When two intervals overlap, always remove the one ending later, because keeping the one ending earlier maximizes the available space for future intervals.
                prevEnd = Math.min(prevEnd, currEnd);
            } else {
                prevEnd = currEnd;
            }
        }

        return ctr;
    }
}
