class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if(target>x+y)return false;
        if(x==target||y==target||x+y==target)return true;
        return target%gcd(x,y)==0;
    }public int gcd(int x,int y){
        if(y==0)return x;
        return gcd(y,x%y);
    }
}