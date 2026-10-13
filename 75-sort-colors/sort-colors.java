class Solution {
    public void sortColors(int[] nums) {
        int z=0,o=0,t=0;
        for(int a:nums){
            if(a==0)z++;
            else if(a==1)o++;
            else t++;
        }
        int id=0;
        int i=0;
        while(i<z){
            nums[id++]=0;
            i++;
        }
        i=0;
        while(i<o){
            nums[id++]=1;
            i++;
        }
        i=0;
        while(i<t){
            nums[id++]=2;
            i++;
        }
    }
}