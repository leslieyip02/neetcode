class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char a = s.charAt(left);
            while (left < right && !Character.isLetterOrDigit(a)) {
                left++;
                a = s.charAt(left);
            }

            char b = s.charAt(right);
            while (left < right && !Character.isLetterOrDigit(b)) {
                right--;
                b = s.charAt(right);
            }
            if (left >= right) {
                break;
            }

            if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

