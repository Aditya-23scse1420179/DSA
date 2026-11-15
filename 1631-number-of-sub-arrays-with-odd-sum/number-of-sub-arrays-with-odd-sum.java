class Solution {
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        int oc=0,ec=1;
        int sum=0,res=0;
        for(int a:arr){
            sum+=a;
            if(sum%2==0){
                res=(res+oc)%1000000007;
                ec++;
            }else {
                res=(res+ec)%1000000007;
                oc++;
            }
        }
        return res;
    }
}