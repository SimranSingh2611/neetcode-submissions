
class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character to the window
            int index = s.charAt(right) - 'A';
            freq[index]++;

            // Track highest frequency encountered
            maxFreq = Math.max(maxFreq, freq[index]);

            // Shrink window if replacements exceed k
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Update maximum window length
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
