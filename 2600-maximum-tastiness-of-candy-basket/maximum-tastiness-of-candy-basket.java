class Solution {
    int[]price;
    int k;
    public int maximumTastiness(int[] price, int k) {
        this.price=price;
        this.k=k;
        Arrays.sort(price);
        int low=0;
        int high=(int)1e9;
        int max=-(int)1e9;
        for(int a:price){
            high=Math.min(a,high);
            max=Math.max(a,max);
        }
        high=max-high;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(helper(mid)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }public boolean helper(int mid){
        int count=1,prev=price[0];
        for(int i=1;i<price.length;i++){
            if(price[i]-prev>=mid){
                prev=price[i];
                count++;
            }
        }
        return count>=k;
    }
}