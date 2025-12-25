class Solution {
    public int search(List<Integer> arr, int k) {
        int low =0;int high=arr.size()-1;
        int ans=-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr.get(mid)==k)return mid;
            if(arr.get(mid)<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
        
    }
    // public int helper(int[][]pairs,int idx,int prev){
    //     if(idx==pairs.length)return 0;
    //     int notTake = helper(pairs,idx+1,prev);
    //     int take = 0;
    //     if(prev==-1 || pairs[prev][1]<pairs[idx][1]){
    //         take = 1+helper(pairs,idx+1,idx);
    //     }
    //     return Math.max(notTake,take);
    // }
    public int maxEnvelopes(int[][] e) {
        Arrays.sort(e,(a,b)->{
            if(a[0]!=b[0])return a[0]-b[0];
            else return b[1]-a[1];
        }
        );
        int nums[]=new int[e.length];
        for(int i=0;i<e.length;i++){
            nums[i]=e[i][1];
        }
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(arr.get(arr.size()-1)<nums[i]){
                arr.add(nums[i]);
            }else{
                arr.set(search(arr,nums[i]),nums[i]);
            }
        }
        return arr.size();
    }
}