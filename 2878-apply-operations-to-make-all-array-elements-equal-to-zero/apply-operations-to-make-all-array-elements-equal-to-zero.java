class Solution {
    public boolean checkArray(int[] nums, int k) {
        int n=nums.length;
        int[]arr=new int[n+1];
        int opp=0;
        for(int i=0;i<n;i++){
            opp+=arr[i];
            int val=nums[i]-opp;
            if(val<0)return false;
            if(val>0){
                if(i+k>n)return false;
                opp+=val;
                arr[i+k]-=val;
            }
        }
        return true;
    }
}