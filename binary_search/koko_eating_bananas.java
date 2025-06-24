class Solution {

    private boolean canFinish(int[] piles, int h, long k) {
        for (int pile : piles) {
            h -= Math.ceil((double) pile / k);
            if (h < 0) {
                return false;
            }
        }
        return h >= 0;
    }

    public int minEatingSpeed(int[] piles, int h) {
        long sum = 0;
        for (int pile : piles) {
            sum += pile;
        }

        long left = 1;
        long right = sum;
        while (left < right) {
            long mid = (left + right) / 2;
            if (canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }
}

