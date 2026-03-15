class Solution {
    public int maxProduct(int[] nums) {
        int min=1;
        int max=1;
        int ans=-(int)1e9;
        for(int i=0;i<nums.length;i++){
            if(min==0)min=1;//0 milt hi dusra subarray start kyunki 0 ke baad sab aage 0 hi ho jayega 
            if(max==0)max=1;// isiliye 0 milte hi reset 0 ke baad waale element ko 1 se mult karke naya subarray suru karo 
            min*=nums[i];//aage se sabka product 
            max*=nums[nums.length-i-1];//piche se sabka prod taki beech ke 
            ans=Math.max(ans,Math.max(min,max));//ans ke sath max lo ans me har iteration ke baad ak value ayegi 
        }
        return ans;
    }
}