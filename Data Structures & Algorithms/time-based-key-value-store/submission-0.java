class TimeMap {

    Map<String, List<String>> keyToValues;
    Map<String, List<Integer>> keyToTimestamp;

    public TimeMap() {
        keyToValues = new HashMap<>();
        keyToTimestamp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyToValues.putIfAbsent(key, new ArrayList<>());
        keyToValues.get(key).add(value);
        
        keyToTimestamp.putIfAbsent(key, new ArrayList<>());
        keyToTimestamp.get(key).add(timestamp);

        // System.out.println(keyToValues);
        // System.out.println(keyToTimestamp);
    }
    
    public String get(String key, int timestamp) {
        List<Integer> list = keyToTimestamp.get(key);
        if (list == null) {
            return "";
        }

        int lo = -1;          // Virtual true endpoint.
        int hi = list.size(); // Virtual false endpoint.

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            if (list.get(mid) <= timestamp) {
                lo = mid; // Qualifies; look for a later qualifying write.
            } else {
                hi = mid; // Too late.
            }
        }

        return lo == -1 ? "" : keyToValues.get(key).get(lo);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
