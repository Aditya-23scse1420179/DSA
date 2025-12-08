class Solution {
    public int largestPrime(int n) {
        int sum =0;
        int ans =0;
        int num=2;
        while(true){
            if(prime(num)){
                sum+=num;
                if(sum>n)break;
                if(prime(sum)){
                    ans=sum;
                }
            }
            num++;
        }
        return ans;
    }
    public boolean prime(int x){
        if(x<2)return false;
        for(int i=2;i*i<=x;i++){
            if(x%i==0)return false;
        }
        return true;
    }
}