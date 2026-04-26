class Solution {
    public int longestSubsequence(int[] arr, int d) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int ans=0;
        for(int a:arr){
            int len=map.getOrDefault(a-d,0)+1;
            map.put(a,len);
            ans=Math.max(ans,len);
        }
        return ans;
    }
}