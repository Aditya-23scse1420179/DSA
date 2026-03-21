class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        long[]pre=new long[n+1];
        pre[0]=nums[0];
        for(int i=1;i<=n;i++){
            pre[i]=pre[i-1]+nums[i-1];
        }
        Deque<Integer>dq=new ArrayDeque<>();
        int ans=n+1;
        for(int j=0;j<=n;j++){
            while(!dq.isEmpty()&&pre[j]-pre[dq.peekFirst()]>=k){
                ans=Math.min(ans,j-dq.pollFirst());
            }
            while(!dq.isEmpty()&&pre[j]<=pre[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(j);
        }
        return ans==n+1?-1:ans;
    }
}