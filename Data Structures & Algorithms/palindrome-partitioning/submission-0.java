class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> out = new ArrayList<>();
        backtrack(s, out, new ArrayList<>(), 0);
        return out;
    }

    private void backtrack(String s, List<List<String>> out, List<String> tempList, int start) {
        if (start == s.length()) {
            out.add(new ArrayList<>(tempList));
        }

        for(int i=start; i<s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                tempList.add(s.substring(start, i+1));
                backtrack(s, out, tempList, i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;

    }
}
