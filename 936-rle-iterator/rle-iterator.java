class RLEIterator {
    int idx;
    int[]encoding;
    public RLEIterator(int[] encoding) {
        this.encoding=encoding;
        this.idx=0;
    }
    
    public int next(int n) {
        while(idx<encoding.length){
            if(n<=encoding[idx]){
                encoding[idx]-=n;
                return encoding[idx+1];
            }else{
                n-=encoding[idx];
                idx+=2;
            }
        }
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */