class Solution {
    public int mySqrt(int x) {
        if(x<2)return x;
        long low=0,high=x/2;
        while(low<=high){
            long mid=(low+high)>>1;
            long sq=mid*mid;
            if(sq==x)return (int)mid;
            if(sq<x)low=mid+1;
            else high=mid-1;
        }
        return (int)high;
    }
}