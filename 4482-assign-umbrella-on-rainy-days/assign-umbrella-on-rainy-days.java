class Solution {
    public String[] assignUmbrella(int[] rain) {
        int d=0;
        String[]st=new String[rain.length];
        for(int i=0;i<rain.length;i++){
            if(rain[i]==0){
                st[i]="None";
                continue;
            }
            if(i==rain.length-1||rain[i+1]==0){
                st[i]="Bob";
                d++;
                continue;
            }
            if(d>=0){
                st[i]="Alice";
                d--;
                continue;
            }
            st[i]="Bob";
            d++;
        }
        return st;
    }
}