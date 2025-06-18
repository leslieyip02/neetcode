class Solution {
    private String sorted(String str) {
        int[] counts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            counts[(int) (str.charAt(i) - 'a')]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Integer>> seen = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String key = sorted(strs[i]);
            seen.computeIfAbsent(key, k -> new ArrayList<>()).add(i);
        }

        List<List<String>> grouped = new ArrayList<>();       
        for (List<Integer> indices : seen.values()) {
            List<String> group = new ArrayList<>();
            for (int i : indices) {
                group.add(strs[i]);
            }
            grouped.add(group);
        }
        return grouped;
    }
}

