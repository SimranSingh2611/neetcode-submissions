class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.add(new int[]{entry.getKey(), entry.getValue()});

            if (minHeap.size() > k)
                minHeap.remove();
        }

        int[] out = new int[k];

        for(int i=0; i<k; i++) {
            out[i] = minHeap.remove()[0];
        }
        
        return out;
    }
}
