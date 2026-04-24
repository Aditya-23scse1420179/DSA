class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer>set=new HashSet<>();
        for(int a:nums1){
            set.add(a);
        }
        Set<Integer>st=new HashSet<>();
        for(int x:nums2){
            if(set.contains(x)){
                st.add(x);
            }
        }
        int[]res=new int[st.size()];
        int id=0;
        for(int a:st){
            res[id++]=a;
        }
        return res;
    }
}