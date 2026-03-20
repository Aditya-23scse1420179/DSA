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
    public List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        int[]sort=nums.clone();
        Arrays.sort(sort);
        int id=0;
        Map<Integer,Integer>map=new HashMap<>();
    
        for(int a:sort){
            if(!map.containsKey(a)){
                map.put(a,id++);
            }
        }segTree seg=new segTree(id);
        Integer[]ans=new Integer[n];
        for(int i=n-1;i>=0;i--){
            int r=map.get(nums[i]);
            ans[i]=seg.query(0,0,id-1,0,r-1);
            seg.update(0,0,id-1,r);
        }
        return Arrays.asList(ans) ;
    }
}