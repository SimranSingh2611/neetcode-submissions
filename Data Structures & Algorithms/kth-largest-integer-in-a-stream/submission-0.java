class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;
    int[] nums;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for(int num : nums)
            add(num);
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.remove();
        }
        return minHeap.peek();
    }
}
