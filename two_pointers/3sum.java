class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> triplets = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int current = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int target = -(current + nums[left]);
                if (nums[right] == target) {
                    List<Integer> triplet = List.of(current, nums[left], nums[right]); 
                    triplets.add(triplet);
                    left++;
                } else if (nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return new ArrayList<>(triplets);
    }
}

