class Solution {
    public int trap(int[] height) {
        int[] prefixes = new int[height.length + 1];
        int[] suffixes = new int[height.length + 1];
        for (int i = 0; i < height.length; i++) {
            prefixes[i + 1] = Math.max(prefixes[i], height[i]);
            suffixes[height.length - 1 - i] = Math.max(
                suffixes[height.length - i],
                height[height.length - 1 - i]
            );
        }

        int total = 0;
        for (int i = 0; i < height.length; i++) {
            total += Math.max(Math.min(prefixes[i], suffixes[i + 1]) - height[i], 0);
        }
        return total;
    }
}

