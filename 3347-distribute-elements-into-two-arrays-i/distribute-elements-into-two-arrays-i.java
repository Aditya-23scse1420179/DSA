class Solution {
    public int[] resultArray(int[] nums) {
        int[]arr1=new int[nums.length];
        int[]arr2=new int[nums.length];
        int id=1,idx=1;
        arr1[0]=nums[0];
        arr2[0]=nums[1];
        for(int i=2;i<nums.length;i++){
            if(arr1[id-1]>arr2[idx-1]){
                arr1[id++]=nums[i];
            }else{
                arr2[idx++]=nums[i];
            }
        }
        int[]result=new int[nums.length];
        int i=0;
        int l1=id,l2=idx;
        id=0;
        while(id<l1){
            result[i++]=arr1[id++];
        }
        idx=0;
        while(idx<l2){
            result[i++]=arr2[idx++];
        }
        return result;


    }
}