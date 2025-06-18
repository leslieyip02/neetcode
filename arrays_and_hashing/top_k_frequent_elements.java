class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> grouped = new ArrayList<>(nums.length + 1);
        for (int i = 0; i < nums.length + 1; i++) {
            grouped.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (grouped.get(count) == null) {
                grouped.set(count, new ArrayList<>());
            }
            grouped.get(count).add(num);
        }

        int[] results = new int[k];
        int count = nums.length;
        int i = 0;
        while (i < k) {
            while (grouped.get(count) == null) {
                count--;
            }

            for (int num : grouped.get(count)) {
                results[i] = num;
                i++;
            }
            count--;
        }
        return results;
    }
}

