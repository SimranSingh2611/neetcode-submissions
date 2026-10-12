class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Set<Integer> hs = new HashSet<>();
        for(int num : nums)
            hs.add(num);
        
        int longestLength = 1;
        for(int num : nums) {
            // check if num is the start of the sequence or not.
            if (!hs.contains(num-1)) {
                // it is the start of the sequence.
                int length = 0;
                // checks for next numbers towards the right.
                while(hs.contains(num+length)) {
                    length++;
                }
                longestLength = Math.max(longestLength, length);
            }
        }
        return longestLength;
        
    }
}
