class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> out = new ArrayList<>();
        int i=0;
        int len = intervals.length;

        // add all the intervals ending before newInterval starts i.e. newInterval starts before current one end -> no overlap -> simply add. 
        while(i < len && newInterval[0] > intervals[i][1]) {
            out.add(intervals[i]);
            i++;
        }

        // we are not right before where the newInterval needs to be added.
        // merge all overlapping intervals to one considering newInterval
        // if end of new interval >= start of current one -> overlap -> can be merged.
        while(i < len && newInterval[1] >= intervals[i][0]) {
            // we could mutate newInterval here also.
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // add the union of intervals we got
        out.add(newInterval);

        // we are done with adding the newInterval and now just add the rest
        while(i < len) {
            out.add(intervals[i]);
            i++;
        }

        return out.toArray(new int[out.size()][]);
    }
}
