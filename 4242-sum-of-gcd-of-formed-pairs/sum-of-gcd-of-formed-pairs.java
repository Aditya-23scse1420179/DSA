class Solution {
    public long gcdSum(int[] nums) {
        int maxi=0;
        int[]pre=new int[nums.length];
        int id=0;
        for(int a:nums){
            maxi=Math.max(maxi,a);
            pre[id++]=gcd(maxi,a);
        }
        Arrays.sort(pre);
        int n=pre.length;
        int i=0,j=n-1;
        long sum=0;
        while(i<j){
            sum+=gcd(pre[i],pre[j]);
            i++;
            j--;
        }
        return sum;
    }
    public int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
}