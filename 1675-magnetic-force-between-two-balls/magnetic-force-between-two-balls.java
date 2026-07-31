class Solution {
    int[]pos;
    int m;
    public int maxDistance(int[] pos, int m) {
        this.pos=pos;
        this.m=m;
        Arrays.sort(pos);
        int ans=0;
        int low=1,high=pos[pos.length-1]-pos[0];
        while(low<=high){
            int mid=low+high>>1;
            if(helper(mid)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;

    }public boolean helper(int mid){
        int prev=pos[0];
        int count=1;
        for(int i=1;i<pos.length;i++){
            if(pos[i]-prev>=mid){
                count++;
                prev=pos[i];
            }
        }
        return count>=m;
    }
} 