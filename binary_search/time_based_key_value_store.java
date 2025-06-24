class TimeMap {

    class Entry {
        String value;
        int timestamp;

        Entry(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Entry>> allEntries;

    public TimeMap() {
        allEntries = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!allEntries.containsKey(key)) {
            allEntries.put(key, new ArrayList<>());
        }
        allEntries.get(key).add(new Entry(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!allEntries.containsKey(key)) {
            return "";
        }

        List<Entry> entries = allEntries.get(key);
        int left = 0;
        int right = entries.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (entries.get(mid).timestamp <= timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left == 0 ? "" : entries.get(left - 1).value;
    }
}

