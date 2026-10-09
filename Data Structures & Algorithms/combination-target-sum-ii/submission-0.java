class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, out, new ArrayList<>());
        return out; 
    }

    private void backtrack(int[] candidates, int target, int startIndex, List<List<Integer>> out, List<Integer> tempList) {
        if (target == 0) {
            out.add(new ArrayList<>(tempList));
            return;
        }

        if (target < 0) {
            return;
        }

        for(int i=startIndex; i<candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i-1])
                continue;
            
            tempList.add(candidates[i]);
            backtrack(candidates, target-candidates[i], i+1, out, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}
