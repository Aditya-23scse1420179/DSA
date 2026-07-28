class Solution {
    public boolean checkArray(int[] nums, int k) {//is waana print opp
        int n=nums.length;
        int[]arr=new int[n+1];
        int opp=0;//one more topp
        for(int i=0;i<n;i++){
            opp+=arr[i];
            int val=nums[i]-opp;
            if(val<0)return false;//-1
            if(val>0){
                if(i+k>n)return false;//-1
                opp+=val;
                arr[i+k]-=val;//topp+=val;
            }
        }
        return true;//return topp
    }
}