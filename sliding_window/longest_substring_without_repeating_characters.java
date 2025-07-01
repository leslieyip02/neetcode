class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        int left = 0;
        int right = 0;
        int length = 0;
        while (right < s.length()) {
            counts.put(s.charAt(right), counts.getOrDefault(s.charAt(right), 0) + 1);
            while (counts.get(s.charAt(right)) > 1) {
                counts.put(s.charAt(left), counts.get(s.charAt(left)) - 1);
                left++;
            }
            length = Math.max(right - left + 1, length);
            right++;
        }
        return length;
    }
}

