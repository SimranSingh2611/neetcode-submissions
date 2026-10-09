class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, out, new ArrayList<>());
        return out; 
    }

    private void backtrack(int[] nums, int startIndex, List<List<Integer>> out, List<Integer> tempList) {
        if (startIndex > nums.length)
            return;

        out.add(new ArrayList<>(tempList));

        for(int i=startIndex; i<nums.length; i++) {
            if (i>startIndex && nums[i] == nums[i-1])
                continue;

            tempList.add(nums[i]);
            backtrack(nums, i+1, out, tempList);
            tempList.remove(tempList.size()-1);
        }
        


    }
}
