class Solution {
    public int distMoney(int money, int children) {
        if (money <children){
            return-1;
        }if (money> 8L*children) {
            return children- 1;
        }
        int extra = money-children;
        int x = extra/7;       
        int r =extra% 7;        
        if (x ==children && r==0) {
            return x;
        }
        if (x ==children -1&&r ==3) {
            return x-1;
        }
        return Math.min(x,children-1);
    }
}
