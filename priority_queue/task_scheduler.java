class Solution {
    private class Task implements Comparable<Task> {
        int task;
        int count;

        Task(int task, int count) {
            this.task = task;
            this.count = count;
        }

        @Override
        public int compareTo(Task other) {
            return other.count - count;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[(int) task - 'A']++;
        }

        PriorityQueue<Task> pending = new PriorityQueue<>();
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0) {
                pending.add(new Task(i, counts[i]));
            }
        }

        int cycles = 0;
        int[] buffered = new int[26];
        for (int i = 0; i < tasks.length - 1; i++) {
            Task current = pending.poll();
            counts[current.task]--;

            if (counts[current.task] > 0) {
                buffered[current.task] = n + 1;
            }

            do {
                for (int j = 0; j < 26; j++) {
                    if (buffered[j] == 0) {
                        continue;
                    }

                    if (buffered[j] == 1) {
                        pending.add(new Task(j, counts[j]));
                    }
                    buffered[j]--;
                }
                cycles++;
            } while (pending.isEmpty());
        }
        return cycles + 1;
    }
}

