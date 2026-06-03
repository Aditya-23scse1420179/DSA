class Solution {
    public int earliestFinishTime(int[] lst, int[] ld, int[] wst, int[] wd) {
        int l=helper(lst,ld,wst,wd);
        int w=helper(wst,wd,lst,ld);
        return Math.min(l,w);
    }public int helper(int[]start,int []end,int[]nstart,int[]nend){
        int min=(int)1e9;
        for(int i=0;i<start.length;i++){
            min=Math.min(min,start[i]+end[i]);
        }
        int ans=(int)1e9;
        for(int j=0;j<nstart.length;j++){
            ans=Math.min(ans,Math.max(min,nstart[j])+nend[j]);
        }
        return ans;
    }
}