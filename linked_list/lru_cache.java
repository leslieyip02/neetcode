class LRUCache {

    Map<Integer, Integer> values;
    Deque<Integer> uses;
    int capacity;

    public LRUCache(int capacity) {
        this.values = new HashMap<>();
        this.uses = new ArrayDeque<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!values.containsKey(key)) {
            return -1;
        }

        uses.remove(key);
        uses.addLast(key);
        return values.get(key);
    }
    
    public void put(int key, int value) {
        values.put(key, value);
        uses.remove(key);
        uses.addLast(key);

        if (uses.size() > capacity) {
            int lru = uses.pollFirst();
            values.remove(lru);
        }
    }

}

