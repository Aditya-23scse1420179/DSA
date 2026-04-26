class Solution {
    public int longestSubsequence(int[] arr, int d) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int ans=0;
        for(int a:arr){
            if(map.containsKey(a-d)){
                map.put(a,map.get(a-d)+1);
            }else{
                map.put(a,1);
            }
            ans=Math.max(ans,map.get(a));

        }
        return ans;
    }
}