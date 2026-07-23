class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        if(n<=2)return n;
        int ans=0;
        for(int a:nums){
            ans|=a;
        }
        return ans+1;
        

    }
}