class Solution {//number ka sq ho raha hai to sign se fark nhi sum max rakhna hai to sort karke sare chote ka sum lelo aur fir larger ke sum se minus
    public long maxAlternatingSum(int[] nums) {
        int[]arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i]*nums[i];
        }
        Arrays.sort(arr);
        long sum=0;
        for(int i=0;i<nums.length/2;i++){
            sum-=arr[i];
        }
        for(int i=nums.length/2;i<nums.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
}