class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] targetCounts = new int[26];       
        for (int i = 0; i < s1.length(); i++) {
            targetCounts[(int) s1.charAt(i) - 'a']++;
        }

        int[] counts = new int[26];
        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            counts[(int) s2.charAt(right) - 'a']++;
            while (counts[(int) s2.charAt(right) - 'a'] > targetCounts[(int) s2.charAt(right) - 'a']) {
                counts[(int) s2.charAt(left) - 'a']--;
                left++;
            }
            right++;

            boolean included = true;
            for (int i = 0; i < 26; i++) {
                if (counts[i] != targetCounts[i]) {
                    included = false;
                }
            }
            if (included) {
                return true;
            }
        }
        return false;
    }
}

