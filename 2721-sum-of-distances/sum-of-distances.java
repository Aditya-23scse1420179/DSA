class Solution {
    public long[] distance(int[] nums) {
        int n=nums.length;
        Map<Integer,List<Integer>>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);

        }
        long[]ans=new long[n];
        for(List<Integer>l:map.values()){
            long res=0;
            for(int idx:l){
                res+=idx;
            }
            long pt=0;
            int sx=l.size();
            for(int i=0;i<sx;i++){
                int idx=l.get(i);
                ans[idx]=res-pt*2+(long)idx*(2*i-sx);
                pt+=idx;
            }
        }
        return ans;
    }
}