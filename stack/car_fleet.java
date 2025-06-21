class Solution {

    class Fleet implements Comparable<Fleet> {
        int position;
        int speed;

        Fleet(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }

        double timeTo(int target) {
            return (double) (target - position) / speed;
        }

        boolean catches(Fleet other, int target) {
            return timeTo(target) <= other.timeTo(target);
        }

        @Override
        public int compareTo(Fleet other) {
            return other.position - position;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<Fleet> fleets = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            fleets.add(new Fleet(position[i], speed[i]));
        }
        Collections.sort(fleets);

        int count = 1;
        Fleet next = fleets.get(0);
        for (int i = 1; i < fleets.size(); i++) {
            Fleet current = fleets.get(i);
            if (!current.catches(next, target)) {
                next = current;
                count++;
            }
        }
        return count;
    }
}

