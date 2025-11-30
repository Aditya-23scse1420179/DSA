class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0L;
        for (int x :nums) total += x;
        int need = (int)(total % p);
        if (need ==0) return 0;         

        int n = nums.length;
        Map<Integer,Integer> lastIndex = new HashMap<>();
        lastIndex.put(0,-1);               
        int best = Integer.MAX_VALUE;
        int prefix = 0;          
        for (int i =0;i < n;i++) {
            prefix =(prefix+ nums[i]) %p;
            int want =(prefix- need)% p;
            if(want <0)want +=p;

            if(lastIndex.containsKey(want)){
                int j =lastIndex.get(want);
                best =Math.min(best,i- j);
            }
            lastIndex.put(prefix,i);
        }
        return (best ==Integer.MAX_VALUE ||best== n)?-1 :best;
    }
}
