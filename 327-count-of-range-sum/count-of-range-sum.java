class Solution {
    static class segTree{
        int n;
        int[]tree;
        public segTree(int n){
            this.n=n;
            tree=new int[4*n];
        }public int query(int idx,int l,int r,int qs,int qe){
            if(r<qs||l>qe)return 0;
            if(l>=qs&&r<=qe){
                return tree[idx];
            }
            int mid=l+(r-l)/2;
            return query(2*idx+1,l,mid,qs,qe)+query(2*idx+2,mid+1,r,qs,qe);
        }public void update(int idx,int l,int r,int val){
            if(l==r){
                tree[idx]++;
                return ;
            }int mid=l+(r-l)/2;
            if(val<=mid){
                update(2*idx+1,l,mid,val);
            }else{
                update(2*idx+2,mid+1,r,val);
            }
            tree[idx]=tree[2*idx+1]+tree[2*idx+2];
        }
    }
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n=nums.length;
        long sum=0;
        TreeSet<Long>set=new TreeSet<>();
        set.add(0L);
        for(int a:nums){
            sum+=a;
            set.add(sum);
            set.add(sum-upper);
            set.add(sum-lower);
        }
        List<Long>list=new ArrayList<>(set);
        int id=0;
        Map<Long,Integer>map=new HashMap<>();
        for(Long a:list){
            if(!map.containsKey(a)){
                map.put(a,id++);
            }
        }int ans=0;
        segTree seg=new segTree(id);
        seg.update(0,0,id-1,map.get(0L));//base case
        sum=0;//reset sum 
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int l=map.get(sum-upper);
            int r=map.get(sum-lower);
            ans+=seg.query(0,0,id-1,l,r);
            seg.update(0,0,id-1,map.get(sum));
        }
        return ans;
    }
}