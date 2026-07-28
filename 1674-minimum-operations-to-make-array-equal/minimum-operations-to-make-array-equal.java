class Solution {
    public int minOperations(int n) {
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=(2*i)+1;
        }
        int opp=0;
        int mid=arr[n/2];
        for(int i=0;i<n;i++){
            if(arr[i]>mid){
                while(arr[i]>mid){
                    arr[i]--;
                    opp++;
                }
            }else if(arr[i]<mid){
                while(arr[i]<mid){
                    arr[i]++;
                    opp++;
                }
            }
        }
        return opp/2;
    }
}