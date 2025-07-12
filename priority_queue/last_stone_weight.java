class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> remaining = new PriorityQueue<>((a, b) -> b - a); 
        for (int stone : stones) {
            remaining.add(stone);
        }

        while (!remaining.isEmpty()) {
            int first = remaining.poll();
            if (remaining.isEmpty()) {
                return first;
            }
            int second = remaining.poll();

            if (first == second) {
                continue;
            }
            remaining.add(first - second);
        }
        return 0;
    }
}

