class Solution {
    public int maxDistance(int[] pos, int m) {
        Arrays.sort(pos);
        int low=1,high=pos[pos.length-1];
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(helper(pos,m,mid)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }public boolean helper(int[]pos,int m,int mid){
        int b=1,p=pos[0];
        for(int i=1;i<pos.length;i++){
            if(pos[i]-p>=mid){
                b++;
                p=pos[i];
            }
        }
        return b>=m;
    }
}