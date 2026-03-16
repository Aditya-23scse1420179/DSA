class NumArray {
    static int[]st;
    int n;
    public NumArray(int[] nums) {
        n=nums.length;
        st=new int[4*n];
        build(nums,0,0,n-1);
    }public void build(int[]nums,int idx,int l,int r){
        if(l==r){
            st[idx]=nums[l];
            return;
        }
        int mid=l+(r-l)/2;
        build(nums,2*idx+1,l,mid);
        build(nums,2*idx+2,mid+1,r);
        st[idx]=st[2*idx+1]+st[2*idx+2];
    }
    
    public void update(int index, int val) {
        updateT(0,index,val,0,n-1);
    }public void updateT(int idx,int i,int val,int l,int r){
        if(l==r){
            st[idx]=val;
            return;
        }
        int mid=l+(r-l)/2;
        if(i<=mid){
            updateT(2*idx+1,i,val,l,mid);
        }else{
            updateT(2*idx+2,i,val,mid+1,r);
        }
        st[idx]=st[2*idx+1]+st[2*idx+2];
    }
    
    public int sumRange(int left, int right) {
        return sum(0,0,n-1,left,right);
    }public int sum(int idx,int l,int r,int qs,int qe){
        if(r<qs||l>qe)return 0;
        if(l>=qs&&r<=qe)return st[idx];
        int mid=l+(r-l)/2;
        int left=sum(2*idx+1,l,mid,qs,qe);
        int right=sum(2*idx+2,mid+1,r,qs,qe);
        return left+right;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */