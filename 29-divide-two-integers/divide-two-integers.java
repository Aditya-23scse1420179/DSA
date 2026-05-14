class Solution {
    public int divide(int div, int dih) {
        if(div==-2147483648&&dih==-1)return 2147483647;
        return (int)Math.ceil(div/dih);
    }
}