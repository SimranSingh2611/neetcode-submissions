class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        backtrack(nums, out, 0, new ArrayList<>());
        return out;
    }

    private void backtrack(int[] nums, List<List<Integer>> out, int startIndex, List<Integer> tempList) {
        if (startIndex > nums.length)
            return;

        out.add(new ArrayList<>(tempList));
        for(int i=startIndex; i<nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(nums, out, i+1, tempList);
            tempList.remove(tempList.size()-1);
        }
        
    }
}
