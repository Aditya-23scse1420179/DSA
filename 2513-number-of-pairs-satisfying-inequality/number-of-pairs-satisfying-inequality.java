class Solution {
    static class SegTree{
        int n;
        int[]tree;
        public SegTree(int n){
            this.n=n;
            tree=new int[4*n];
        }
        public int query(int idx,int l,int r,int qs,int qe){
            if(r<qs||l>qe)return 0;
            if(l>=qs&&r<=qe)return tree[idx];
            int mid=l+(r-l)/2;
            return query(2*idx+1,l,mid,qs,qe)+query(2*idx+2,mid+1,r,qs,qe);
        }public void update(int idx,int l,int r,int val){
            if(l==r){
                tree[idx]++;
                return;
            }
            int mid=l+(r-l)/2;
            if(val<=mid){
                update(2*idx+1,l,mid,val);
            }else{
                update(2*idx+2,mid+1,r,val);
            }
            tree[idx]=tree[2*idx+1]+tree[2*idx+2];

        }
    }
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n=nums1.length;
        int[]ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=nums1[i]-nums2[i];
        }
        TreeSet<Integer>set=new TreeSet<>();
        for(int val:ans){
            set.add(val);
            set.add(val+diff);
        }
        List<Integer>list=new ArrayList<>(set);
        int id=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<list.size();i++){
            if(!map.containsKey(list.get(i))){
                map.put(list.get(i),id++);
            }
        }
        long count=0;
        SegTree seg=new SegTree(id);
        for(int j=0;j<n;j++){
            int right=map.get(ans[j]+diff);
            count+=seg.query(0,0,id-1,0,right);
            seg.update(0,0,id-1,map.get(ans[j]));
        }
        return count;
    }
}