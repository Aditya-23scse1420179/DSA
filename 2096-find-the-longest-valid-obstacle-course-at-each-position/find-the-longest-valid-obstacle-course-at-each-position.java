class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obs) {
        int n=obs.length;
        int[]dp=new int[n];
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            int idx=bs(ans,obs[i]);
            if(idx==ans.size()){
                ans.add(obs[i]);
            }else{
                ans.set(idx,obs[i]);
            }
            dp[i]=idx+1;
        }
        return dp;
    }public int bs(ArrayList<Integer>ans,int target){
        int low=0;
        int high=ans.size()-1;
        while(low<=high){
            int mid=(low+high)>>1;
            if(ans.get(mid)<=target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
}