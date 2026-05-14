class Solution {
    public int divide(int div, int dih) {
        if(div==Integer.MIN_VALUE&&dih==-1)return Integer.MAX_VALUE;
        return (int)Math.ceil(div/dih);
    }
}