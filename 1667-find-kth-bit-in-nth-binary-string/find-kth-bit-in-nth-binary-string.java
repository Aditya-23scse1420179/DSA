class Solution {
    public char findKthBit(int n, int k) {
        if(n==1)return '0';
        int len = (1<<n) -1;
        int half= len/2+1;
        if(k==half)return '1';
        if(k<half){
            return findKthBit(n-1,k);
        }else {
            char ch = findKthBit(n-1,len-k+1);
                if(ch=='0'){
                    return '1';
                }else{
                    return '0';
                }   
        }
    }
}