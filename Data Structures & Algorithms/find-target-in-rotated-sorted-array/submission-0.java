class Solution {
    public int search(int[] nums, int target) {
     // Idea - find index of the minimum element. So separate binary searches on both the sides of the min element.
        int minElementIndex = findMinIndex(nums);
        int n = nums.length;
       
        int leftHalf = binarySearch(nums, -1, minElementIndex, target);
        if (leftHalf != -1)
            return leftHalf;
        int rightHalf = binarySearch(nums, minElementIndex-1, n-1, target);
        return rightHalf;   
    }

    // minimization problem - we need to find first element that is lesser than last element. 
    public int findMinIndex(int[] nums) {

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
        
        return right;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {

        while (start + 1 < end) {
            int mid = start + (end - start)/2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] >= target)
                end = mid;
            else
                start = mid;
        }
        return nums[end] == target ? end : -1;
    }
}