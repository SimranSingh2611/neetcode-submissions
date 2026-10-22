class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<>();

        for(int num : nums) {
            if (!hs.add(num))
                return true;
        }
        
        return false;
    }
}