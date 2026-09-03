class Solution {
    public boolean uniformArray(int[] nums1) {
        int e=0,o=0;
        for(int a:nums1){
            if(a%2==0)e++;
            else o++;
        }
        if(e==nums1.length||o==nums1.length)return true;
        Arrays.sort(nums1);
        if(nums1[0]%2!=0)return true;
        return false;
    }
}