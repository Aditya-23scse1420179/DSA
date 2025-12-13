class Solution {
    int ans=0;
    public int countArrangement(int n) {
        if(n==1)return 1;
        track(1,n,new int[n+1]);
        return ans;
    }
    public void track(int pos,int n,int[]usedValue){
        if(pos>n){
            ans++;
            return;
        }
        for(int i=1;i<=n;i++){
            if(usedValue[i]==0&&(pos%i==0||i%pos==0)){
                usedValue[i]=1;
                track(pos+1,n,usedValue);
                usedValue[i]=0;
            }
        }
    }
}