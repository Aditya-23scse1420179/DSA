class NumArray {
    static int st[];
    int n;
    public NumArray(int[] nums) {
        n=nums.length;
        st=new int[4*n];
        build(0,0,n-1,nums);
    }public void build(int idx,int l,int r,int []nums){
        if(l==r){
            st[idx]=nums[l];
            return;
        }
        int mid=l+r>>1;
        build(2*idx+1,l,mid,nums);
        build(2*idx+2,mid+1,r,nums);
        st[idx]=st[2*idx+1]+st[2*idx+2];
    }
    
    public void update(int index, int val) {
        updatee(0,0,n-1,val,index);
    }public void updatee(int idx,int l,int r,int val,int i){
        if(l==r){
            st[idx]=val;
            return;
        }
        int mid=l+r>>1;
        if(i<=mid){
            updatee(2*idx+1,l,mid,val,i);
        }else{
            updatee(2*idx+2,mid+1,r,val,i);
        }
        st[idx]=st[2*idx+1]+st[2*idx+2];
    }
    
    public int sumRange(int left, int right) {
        return sum(0,0,n-1,left,right);
    }public int sum(int idx,int l,int r,int qs,int qe){
        if(qs>r||l>qe)return 0;
        if(l>=qs&&r<=qe)return st[idx];
        int mid=l+r>>1;
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