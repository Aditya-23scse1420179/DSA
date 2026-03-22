class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
        int c1=0;
        int c2=0;
        for(int i=0;i<n;i++){
            if(nums1[i]%2==0)c1++;
            else c2++;
        }
        if(c1==n||c2==n)return true;
        Arrays.sort(nums1);
        if(nums1[0]%2!=0)return true;
        return false;
    }

}