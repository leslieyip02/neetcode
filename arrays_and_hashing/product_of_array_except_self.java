class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixes = new int[nums.length + 1];
        int[] suffixes = new int[nums.length + 1];

        prefixes[0] = 1;
        suffixes[nums.length] = 1;
        for (int i = 0; i < nums.length; i++) {
            prefixes[i + 1] = prefixes[i] * nums[i];
            suffixes[nums.length - 1 - i] = suffixes[nums.length - i] * nums[nums.length - 1 - i];
        }

        int[] products = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            products[i] = prefixes[i] * suffixes[i + 1];
        }
        return products;
    }
}  

