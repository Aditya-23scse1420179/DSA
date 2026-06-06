// 3 main kaam hain 
// segment tree me convert 
//query me kya value pass 
// kya value update 
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
    public int reversePairs(int[] nums) {
        int n=nums.length;
        TreeSet<Long>set=new TreeSet<>();
        for(int a:nums){
            set.add((long)a);
            set.add(2L*a);
        }
        List<Long>list=new ArrayList<>(set);
        Map<Long,Integer>map=new HashMap<>();
        int id=0;
        for(int i=0;i<list.size();i++){
            if(!map.containsKey(list.get(i))){
                map.put(list.get(i),id++);
            }
        }
        SegTree seg=new SegTree(id);
        int ans=0;
        for (int j = 0; j < nums.length; j++) {
            int pos2 = map.get(2L * nums[j]);
            ans += seg.query(0, 0, id-1, pos2+1, id-1);
            int pos = map.get((long)nums[j]);
            seg.update(0, 0, id-1, pos);
        }

        return ans;
    }
}