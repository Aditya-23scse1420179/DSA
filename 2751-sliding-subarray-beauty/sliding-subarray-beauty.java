class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] arr = new int[n-k+1];
        int[] freq = new int[101];
        for (int i=0;i<k;i++){
            freq[nums[i]+50]++;
        }
        int id=0;
        arr[id++] =helper(freq,x);
        int i=1,j=k;
        while(j<n){
            freq[nums[j]+50]++;   
            freq[nums[i-1]+50]--; 
            arr[id++]=helper(freq, x);
            i++;
            j++;
        }
        return arr;
    }
    public int helper(int[]freq,int x) {
        int count=0;
        for(int idx=0;idx<50;idx++){
            count+=freq[idx];
            if(count>=x) {//loop sirf -ve pe chalega aur josa chahiye hoga utna count karke ruk jayega 
                return idx-50;
            }
        }
        return 0;
    }
}