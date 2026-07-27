class Solution {
    public int maxProduct(int[] nums) {
        int max1=0,max2=0;
        for(int a:nums){
            if(a>max1){
                max2=max1;
                max1=a;
            }else if(a>max2){
                max2=a;
            }
        }
        System.out.print(max2);
        return (max1-1)*(max2-1);
    }
}