class Solution {
    public int minOperations(int[] nums) {
        int opp=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                while(!isprime(nums[i])){
                    nums[i]++;
                    opp++;
                }
            }else {
                while(isprime(nums[i])){
                    nums[i]++;
                    opp++;
                }
            }
        }
        return opp;
    }public boolean isprime(int x){
        if(x<2)return false;
        for(int i=2;i*i<=x;i++){
            if(x%i==0)return false;
        }
        return true;
    }
}