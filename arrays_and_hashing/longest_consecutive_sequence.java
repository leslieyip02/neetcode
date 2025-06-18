class Solution {
    private int dfs(int current, int delta, Set<Integer> available, Set<Integer> visited) {
        if (!available.contains(current)) {
            return 0;
        }

        visited.add(current);
        return dfs(current + delta, delta, available, visited) + 1;
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> available = new HashSet<>();
        for (int num : nums) {
            available.add(num);
        }

        int longest = 0;
        Set<Integer> visited = new HashSet<>();
        for (int num : available) {
            if (visited.contains(num)) {
                continue;
            }
            int length = dfs(num, 1, available, visited) + dfs(num, -1, available, visited) - 1;
            longest = Math.max(length, longest);
        }
        return longest;
    }
}

