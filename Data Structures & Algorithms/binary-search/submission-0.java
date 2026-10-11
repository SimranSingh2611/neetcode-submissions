class Solution {
    /*
    * TYPE: MINIMIZATION -- first index with nums[i] >= target.
    * BOUNDS: lo=-1 (false), hi=n (virtual true); sentinels stay unread.
    * RESULT: hi if in range and equal; otherwise -1.
    */
    // O(log(n + 1)) time, O(1) auxiliary space. Does not mutate nums.
    public int search(int[] nums, int target) {

        int lo = -1;
        int hi = nums.length;
        while (lo + 1 < hi) {
            int mid = lo + (int) (((long) hi - lo) / 2);
            if (nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        
        return  hi < nums.length && nums[hi] == target ? hi : -1;
    }
}
