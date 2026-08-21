class Solution {
    public int nthUglyNumber(int n) {
        int []nums=new int[n+1];
        nums[0]=1;
        int u=0,i1=0,i2=0,i3=0;
        for(int i=1;i<n;i++){
            nums[i]=Math.min(Math.min(2*nums[i1],3*nums[i2]),5*nums[i3]);
            u=nums[i];
            if(nums[i1]*2==u)i1++;
            if(nums[i2]*3==u)i2++;
            if(nums[i3]*5==u)i3++;
        }
        return nums[n-1];
    }
}