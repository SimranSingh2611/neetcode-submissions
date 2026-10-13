
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> freqMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for (char c : s1.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int windowSize = s1.length();
        int left = 0, right = 0;

        while (right < s2.length()) {

            // 1. Calculations: include right character
            char rightChar = s2.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            // 2. Window size > required: shrink
            if (right - left + 1 > windowSize) {

                char leftChar = s2.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (windowMap.get(leftChar) == 0)
                    windowMap.remove(leftChar);

                left++;
            }

            // 3. Window size == required: check answer
            if (right - left + 1 == windowSize) {
                if (freqMap.equals(windowMap))
                    return true;
            }

            // 4. Expand window
            right++;
        }

        return false;
    }
}
