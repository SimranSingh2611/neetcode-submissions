class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.distance - a.distance);

        for(int[] point : points) {
            int dist = (point[0] * point[0]) + (point[1] * point[1]);
            Pair p = new Pair(point, dist);

            maxHeap.add(p);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }

        int[][] out = new int[maxHeap.size()][2];
        for(int i=0; i<out.length; i++) {
            out[i] = maxHeap.poll().point;
        }

        return out;
    }

    class Pair {
        int[] point;
        int distance;

        Pair(int[] point, int distance) {
            this.point = point;
            this.distance = distance;
        }
    }
}
