class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> out = new ArrayList<>();
        backtrack(nums, target, 0, out, new ArrayList<>(), 0);
        return out;
    }

    private void backtrack(int[] nums, int target, int currSum, List<List<Integer>> out, List<Integer> tempList, int startIndex) {
        if (target == 0) {
            out.add(new ArrayList<>(tempList));
            return;
        }
        if (target < 0) {
            return;
        }

        
        for(int i=startIndex; i<nums.length; i++) {
            tempList.add(nums[i]);

            backtrack(nums, target-nums[i], currSum, out, tempList, i);
            tempList.remove(tempList.size()-1);
        }

    }
}

