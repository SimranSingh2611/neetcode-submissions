
class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> freq = new HashMap<>();

        int left = 0, right = 0;
        int maxFreq = 0;
        int ans = 0;
        int size = s.length();

        while (right < size) {

            // 1. Calculations: include s[right]
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            maxFreq = Math.max(maxFreq, freq.get(c));

            // 2. Condition > k: shrink window
            while ((right - left + 1) - maxFreq > k) {

                // Remove calculations for left
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);

                left++;
            }

            // 3. Condition <= k: update answer
            ans = Math.max(ans, right - left + 1);

            // 4. Expand window
            right++;
        }

        return ans;
    }
}
