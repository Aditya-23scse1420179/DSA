class KthLargest {
    int k;
    PriorityQueue<Integer>q;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        q=new PriorityQueue<>();
        for(int a:nums){
            q.offer(a);
            if(q.size()>k)q.remove();
        }
    }
    
    public int add(int val) {
        q.offer(val);
        if(q.size()>k)q.remove();
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */