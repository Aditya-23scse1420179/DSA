class Solution {
    public int gcdOfOddEvenSums(int n) {
        int even =0,odd=0;
        int e=n,o=n;
        for(int i=1;e>0||o>0;i++){
            if(i%2==0&&e>=1){
                even+=i;
                e--;
            }else if(i%2!=0&&o>=1){
                odd+=i;
                o--;
            }
        }
        return gcd(even,odd);
    }
    public int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
}