class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        int left = 0, right = 0;
        Set<Character> hs = new HashSet<>();
        int maxLength = Integer.MIN_VALUE;

        while(right < n) {
            char rightChar = s.charAt(right);

            if (hs.add(rightChar)) {
                int length = right-left+1;
                maxLength = Math.max(maxLength, length);
                right++;
            } else {
                char leftChar = s.charAt(left);
                hs.remove(leftChar);
                left++;
            }


        }
        return maxLength;
    }
}
