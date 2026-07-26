class Solution {
    public int maximumProduct(int[] nums) {
        int max1=-(int)1e9,max2=-(int)1e9,max3=-(int)1e9;
        int min1=(int)1e9,min2=(int)1e9;
        for(int a:nums){
            if(max1<a){
                max3=max2;
                max2=max1;
                max1=a;
            }else if(max2<a){
                max3=max2;
                max2=a;
            }else if(max3<a){
                max3=a;
            }
            if(min1>a){
                min2=min1;
                min1=a;
            }else if(min2>a){
                min2=a;
            }
        }
        return Math.max(max1*max2*max3,min1*min2*max1);
    }
}