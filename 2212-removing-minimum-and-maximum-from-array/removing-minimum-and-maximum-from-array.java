class Solution {
    public int minimumDeletions(int[] nums) {
        int ans=0;
        if(nums.length<=2)return nums.length;
        int min=(int)1e9,max=0;
        for(int a:nums){
            min=Math.min(min,a);
            max=Math.max(a,max);
        }int x=0,y=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==min)x=i+1;
            if(nums[i]==max)y=i+1;
        }
        int left=Math.min(x,y);//aage se dist
        int right=Math.max(x,y);//piche se dist
        int c1=right;//dono ko aage se 
        int c2=nums.length-left+1;//dono ko piche se 
        int c3=left+(nums.length-right+1);//ak ko age ak ko piche 
        return Math.min(c1,Math.min(c2,c3));
    }
}