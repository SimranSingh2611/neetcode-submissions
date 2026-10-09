
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        backtrack(nums, out, new ArrayList<>());
        return out;
    }

    private void backtrack(int[] nums, List<List<Integer>> out,
                           List<Integer> tempList) {

        if (tempList.size() == nums.length) {
            out.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Cannot reuse an element already selected
            if (tempList.contains(nums[i]))
                continue;

            // Choose
            tempList.add(nums[i]);

            // Explore
            backtrack(nums, out, tempList);

            // Backtrack
            tempList.remove(tempList.size() - 1);
        }
    }
}
