class Solution {
    public int minAllOneMultiple(int k) {
        if(k%2==0||k%5==0)return -1;
        int res=0;
        for(int len=1;len<=k;len++){
            res=(res*10+1)%k;
            if(res==0)return len;
        }
        return -1;
    }
}