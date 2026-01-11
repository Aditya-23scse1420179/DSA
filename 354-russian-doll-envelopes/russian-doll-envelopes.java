class Solution {
    public int maxEnvelopes(int[][] e) {
        Arrays.sort(e,(a,b)->{
            if(a[0]!=b[0])return a[0]-b[0];
            else return b[1]-a[1];
        });
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<e.length;i++){
            int h=e[i][1];
            int idx=lb(ans,h);
            if(idx==ans.size()){
                ans.add(h);
            }else{
                ans.set(idx,h);
            }
        }
        return ans.size();
    }
    public int lb(List<Integer>ans,int target){
        int low=0;
        int high=ans.size()-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(ans.get(mid)>=target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}