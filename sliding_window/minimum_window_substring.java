class Solution {
    private boolean contains(
        Map<Character, Integer> counts,
        Map<Character, Integer> targetCounts
    ) {
        for (Map.Entry<Character, Integer> entry : targetCounts.entrySet()) {
            char letter = entry.getKey();
            int count = entry.getValue();
            if (counts.getOrDefault(letter, 0) < count) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> targetCounts = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            targetCounts.put(t.charAt(i), targetCounts.getOrDefault(t.charAt(i), 0) + 1);
        }

        Map<Character, Integer> counts = new HashMap<>();
        int left = 0;
        int right = 0;
        String minimum = "";
        while (right < s.length()) {
            while (right < s.length() && !contains(counts, targetCounts)) {
                counts.put(s.charAt(right), counts.getOrDefault(s.charAt(right), 0) + 1);
                right++;
            }

            while (left < right && contains(counts, targetCounts)) {
                int length = right - left;
                if (minimum.equals("") || length < minimum.length()) {
                    minimum = s.substring(left, right);
                }
                counts.put(s.charAt(left), counts.get(s.charAt(left)) - 1);
                left++;
            }
        }
        return minimum;
    }
}

