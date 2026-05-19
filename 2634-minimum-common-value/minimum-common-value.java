class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int ans=Integer.MAX_VALUE;
        Set<Integer>set=new HashSet<>();
        for(int a:nums1){
            set.add(a);
        }
        for(int a:nums2){
            if(set.contains(a)){
                ans=Math.min(ans,a);
            }
        }
        return ans>=Integer.MAX_VALUE?-1:ans;
    }
}