class Solution {
    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int currSum = 0;
        for(int num : nums) {
            if (currSum < 0)
                currSum = 0;
            
            currSum += num;
            max = Math.max(max, currSum);
        }

        return max;
        
    }
}
