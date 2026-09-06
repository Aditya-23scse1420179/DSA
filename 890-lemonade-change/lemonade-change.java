class Solution {
    public boolean lemonadeChange(int[] bills) {
        int f=0,t=0;
        for(int a:bills){
            if(a==5)f++;
            if(a==10){
                if(f>0){
                    f-=1;
                    t++;
                }else return false;
            }
            if(a==20){
                if(f>0&&t>0){
                    t--;
                    f--;
                }
                else if(f>=3){
                    f-=3;
                }else return false;
            }
        }
        return true;
    }
}