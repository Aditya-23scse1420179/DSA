class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int left=0,sum=0,min=(int)1e9,res=(int)1e9;
        
        int[]num=new int[arr.length];
        Arrays.fill(num,(int)1e9);
        for(int right=0;right<arr.length;right++){
            sum+=arr[right];
            while(sum>target){
                sum-=arr[left];
                left++;
            }
            if(sum==target){
                if(left>0&&num[left-1]!=(int)1e9){
                    res=Math.min(res,(right-left+1)+num[left-1]);
                }
                min=Math.min(min,right-left+1);
                
            }
            num[right]=(right>0)?Math.min(num[right-1],min):min;
            
        }
        return res==(int)1e9?-1:res;
    }
}