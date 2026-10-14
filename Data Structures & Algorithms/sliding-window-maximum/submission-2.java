class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] out = new int[n - k + 1];

        // Max Heap: {value, index}
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );

        int left = 0, right = 0;
        int index = 0;

        while (right < n) {

            // 1. Include right element
            maxHeap.offer(new int[]{nums[right], right});

            // 2. Shrink when window exceeds k
            if (right - left + 1 > k) {
                left++;
            }

            // 3. Remove expired heap elements
            while (!maxHeap.isEmpty() &&
                maxHeap.peek()[1] < left) {
                maxHeap.poll();
            }

            // 4. Store maximum when window size == k
            if (right - left + 1 == k) {
                out[index++] = maxHeap.peek()[0];
            }

            right++;
        }

        return out;
    }
}
