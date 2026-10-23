
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        if (sum % 2 != 0)
            return false;

        Map<String, Boolean> cache = new HashMap<>();

        return canPartitionRecursion(nums, 0, sum / 2, cache);
    }

    private boolean canPartitionRecursion(int[] nums, int i, int target, Map<String, Boolean> cache) {

        if (target == 0)
            return true;

        if (i == nums.length || target < 0)
            return false;

        String key = i + "," + target;

        Boolean cached = cache.get(key);
        
        if (cached != null)
            return cached;

        boolean result = canPartitionRecursion(nums, i + 1, target, cache) || canPartitionRecursion(nums, i + 1, target - nums[i], cache);

        cache.put(key, result);

        return result;
    }
}
