class Solution {
    public int maximumSum(int[] arr) {
        int ans=arr[0];
        int del1=arr[0];
        int ndel=arr[0];
        for(int i=1;i<arr.length;i++){
            int pdel=ndel;
            ndel=Math.max(arr[i],ndel+arr[i]);
            del1=Math.max(pdel,del1+arr[i]);
            ans=Math.max(ans,Math.max(ndel,del1));
        }
        return ans;
    }
}