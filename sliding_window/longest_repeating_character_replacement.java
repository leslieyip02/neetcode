class Solution {
    private int replacements(int[] counts) {
        int most = 0;
        int total = 0;
        for (int count : counts) {
            most = Math.max(count, most);
            total += count;
        }
        return total - most;
    }

    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int left = 0;
        int right = 0;
        int length = 1;
        while (right < s.length()) {
            counts[(int) s.charAt(right) - 'A']++;
            while (replacements(counts) > k) {
                counts[(int) s.charAt(left) - 'A']--;
                left++;
            }
            length = Math.max(right - left + 1, length);
            right++;
        }
        return length;
    }
}

