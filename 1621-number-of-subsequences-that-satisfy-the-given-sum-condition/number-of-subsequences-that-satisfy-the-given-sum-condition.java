class Solution {
    public int numSubseq(int[] nums, int target) {
        sort(nums);
        int l=0,r=nums.length-1,res=0;
        int[]pow = new int[nums.length];
        pow[0] =1;
        for(int i=1;i<nums.length;i++){
            pow[i]=(pow[i-1]*2)%1000000007;
        }
        while(l<=r){
            if(nums[l]+nums[r]<=target){
                res=(res+pow[r-l])%1000000007;
                l++;
            }else{
                r--;
            }
        }
        return res;
    }public void sort(int[]nums){
        int min=(int)1e9,max=-(int)1e9;
        for(int a:nums){
            min=Math.min(min,a);
            max=Math.max(max,a);
        }
        int[]freq=new int[max-min+1];
        for(int a:nums){
            freq[a-min]++;
        }int id=0;
        for(int i=0;i<freq.length;i++){
            while(freq[i]>0){
                nums[id++]=i+min;
                freq[i]--;
            }
        }
    }
}