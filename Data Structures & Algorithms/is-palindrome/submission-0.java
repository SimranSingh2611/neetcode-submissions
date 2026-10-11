class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;

        while (left <= right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (!Character.isLetterOrDigit(leftChar) || leftChar == ' ') {
                left++;
            } else if (!Character.isLetterOrDigit(rightChar) || rightChar == ' ') {
                right--;
            } else if (leftChar == rightChar) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }
}
