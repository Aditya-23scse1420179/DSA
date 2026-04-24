class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int left=0,right=0;
        for(int x:nums1){
            for(int y:nums2){
                if(x==y){
                    left++;
                    break;
                }
            }
        }
        for(int a:nums2){
            for(int b:nums1){
                if(a==b){
                    right++;
                    break;
                }
            }
        }
        return new int[]{left,right};
    }
}