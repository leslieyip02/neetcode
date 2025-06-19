class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int complement = target - numbers[left];
            if (numbers[right] == complement) {
                return new int[]{ left + 1, right + 1 };
            } else if (numbers[right] > complement) {
                right--;
                continue;
            } else {
                left++;
            }
        }
        return new int[]{};
    }
}

