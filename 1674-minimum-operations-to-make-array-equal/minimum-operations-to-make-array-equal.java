class Solution {
    public int minOperations(int n) {
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=(2*i)+1;
        }
        int opp=0;
        for(int i=0;i<n/2;i++){
            opp+=Math.abs(arr[i]-n);
        }
        return opp;
    }
}