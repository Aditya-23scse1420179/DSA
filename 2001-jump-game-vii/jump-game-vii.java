class Solution {
    public boolean canReach(String s, int min, int max) {
    int n=s.length();
    if(s.charAt(n-1)=='1'){
        return false;

    }
    int []arr=new int[n];
    int count=0;
    for(int i=0;i<n;i++){
        count+=arr[i];
        if(i==0||(s.charAt(i)=='0'&&count>0)){
            if(i+min<n){
                arr[i+min]+=1;
            }
            if(i+max+1<n)
            {
                arr[i+max+1]-=1;
            }
        }
    }
    return count>0;
}
}