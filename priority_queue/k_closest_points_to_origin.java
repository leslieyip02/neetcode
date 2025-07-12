class Solution {
    private double distance(Integer[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer[]> furthest = new PriorityQueue<Integer[]>((a, b) -> {
            return (int) Math.signum(distance(b) - distance(a));
        });

        for (int[] point : points) {
            furthest.add(new Integer[]{ point[0], point[1] });
            while (furthest.size() > k) {
                furthest.poll();
            }
        }

        int[][] closest = new int[k][2];
        int i = 0;
        while (!furthest.isEmpty()) {
            Integer[] current = furthest.poll();
            closest[i][0] = current[0];
            closest[i][1] = current[1];
            i++;
        }
        return closest;
    }
}

