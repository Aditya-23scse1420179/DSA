class Solution {
    static int[]h;
    static int[]st;
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n=heights.length;
        st=new int[4*n];
        h=heights;
        build(0,0,n-1);
        int[]ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int a=queries[i][0];
            int b=queries[i][1];
            if(a>b){
                int temp=a;
                a=b;
                b=temp;
            }
            if(a==b){
                ans[i]=a;
                continue;
            }
            if(h[a]<h[b]){
                ans[i]=b;
                continue;
            }
            int target=Math.max(h[a],h[b]);
            ans[i]=sum(0,0,n-1,b+1,target);
        }
        return ans;
    }public void build(int idx,int l,int r){
        if(l==r){
            st[idx]=h[l];
            return ;
        }
        int mid=l+(r-l)/2;
        build(2*idx+1,l,mid);
        build(2*idx+2,mid+1,r);
        st[idx]=Math.max(st[2*idx+1],st[2*idx+2]);
    }public int sum(int idx,int l,int r,int qs,int target){
        if(r<qs||st[idx]<=target)return -1;
        if(l==r)return l;
        int ans=-1;
        int mid=l+(r-l)/2;
        if(mid>=qs){
            ans=sum(2*idx+1,l,mid,qs,target);
        }if(ans!=-1)return ans;
        return ans=sum(2*idx+2,mid+1,r,qs,target);
    }
}