class Solution {
    static int[] minSeg;
    static int[] maxSeg;
    static int[] arr;
    static int mn, mx;
    static class Node {
        int i, j;
        long val;
        Node(int i, int j, long val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
    public long maxTotalValue(int[] nums, int k) {
        arr = nums;
        int n = nums.length;
        minSeg = new int[4 * n];
        maxSeg = new int[4 * n];
        build(0, 0, n - 1);
        PriorityQueue<Node> pq =new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));
        for (int i = 0; i < n; i++) {
            mn = Integer.MAX_VALUE;
            mx = Integer.MIN_VALUE;
            query(0, 0, n - 1, i, n - 1);
            pq.offer(new Node(i, n - 1, (long) mx - mn));
        }
        long ans = 0;
        while (k-- > 0) {
            Node cur = pq.poll();
            ans += cur.val;
            int i = cur.i;
            int j = cur.j - 1;
            if (i <= j) {
                mn = Integer.MAX_VALUE;
                mx = Integer.MIN_VALUE;
                query(0, 0, n - 1, i, j);
                pq.offer(new Node(i, j, (long) mx - mn));
            }
        }
        return ans;
    }
    static void build(int idx, int l, int r) {
        if (l == r) {
            minSeg[idx] = arr[l];
            maxSeg[idx] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        build(2 * idx + 1, l, mid);
        build(2 * idx + 2, mid + 1, r);
        minSeg[idx] = Math.min(minSeg[2 * idx + 1], minSeg[2 * idx + 2]);
        maxSeg[idx] = Math.max(maxSeg[2 * idx + 1], maxSeg[2 * idx + 2]);
    }
    static void query(int idx, int l, int r, int qs, int qe) {
        if (r < qs || l > qe)
            return;
        if (l >= qs && r <= qe) {
            mn = Math.min(mn, minSeg[idx]);
            mx = Math.max(mx, maxSeg[idx]);
            return;
        }
        int mid = l + (r - l) / 2;
        query(2 * idx + 1, l, mid, qs, qe);
        query(2 * idx + 2, mid + 1, r, qs, qe);
    }
}