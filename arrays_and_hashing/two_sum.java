class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            int complement = target - nums[j];
            if (seen.containsKey(complement)) {
                int i = seen.get(complement);
                return new int[]{ i, j };
            }
            seen.put(nums[j], j);
        }
        return new int[]{};
    }
}

