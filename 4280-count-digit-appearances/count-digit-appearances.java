class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int n=nums.length;
        int res=0;
        for(int a:nums){
            if(a==0&&digit==0){
                res++;
            }
            while(a>0){
                if(a%10==digit)res++;//give last digit
                a/=10;//remove last digit
            }
        }
        return res;
    }
}