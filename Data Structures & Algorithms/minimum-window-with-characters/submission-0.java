
class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> freqMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        int required = freqMap.size();
        int formed = 0;

        while (right < s.length()) {

            // 1. Include right character
            char rightChar = s.charAt(right);

            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            // Check if this character meets required frequency
            if (freqMap.containsKey(rightChar) && windowMap.get(rightChar).equals(freqMap.get(rightChar))) {
                formed++;
            }

            // 2. Keep shrinking while window is valid
            while (formed == required) {

                // Update minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                // Remove left character
                char leftChar = s.charAt(left);

                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                // Check if removing it invalidates window
                if (freqMap.containsKey(leftChar) && windowMap.get(leftChar) < freqMap.get(leftChar)) {
                    formed--;
                }

                left++;
            }

            // 3. Expand right
            right++;
        }

        if (minLen == Integer.MAX_VALUE)
            return "";

        return s.substring(minStart, minStart + minLen);
    }
}
