class Solution {
    // minimization problem - we need to find first element that is lesser than last element. 
    public int findMin(int[] nums) {

        int left = -1, right = nums.length-1;
        int lastElem = nums[right];

        while (left + 1 < right) {
            int mid = left + (right-left)/2;

            if (nums[mid] >= lastElem) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        return nums[right];
    }
}
