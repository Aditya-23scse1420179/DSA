class Solution {
    public int maxProductDifference(int[] nums) {
        int m1=Integer.MIN_VALUE,m2=Integer.MIN_VALUE;
        int s1=Integer.MAX_VALUE,s2=Integer.MAX_VALUE;
        for(int a:nums){
            if(a>m1){
                m2=m1;
                m1=a;
                
            }
            else if(a>m2){
                m2=a;
            }
            if(s1>a){
                s2=s1;
                s1=a;
            }
            else if(a<s2){
                s2=a;
            }
        }
        return m1*m2-s1*s2;

    }
}