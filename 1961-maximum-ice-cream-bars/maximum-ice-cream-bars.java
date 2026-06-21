class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max=-(int)1e9,min=(int)1e9;
        for(int x:costs){
            min=Math.min(x,min);
            max=Math.max(x,max);
        }
        int[]freq=new int[max-min+1];
        for(int x:costs){
            freq[x-min]++;
        }int idx=0;
        for(int i=0;i<freq.length;i++){
            while(freq[i]>0){
                costs[idx++]=i+min;
                freq[i]--;
            }
        }
        for(int x:costs){
            System.out.println(x);
        }
        int count=0;
        int sum=0;
        for(int i=0;i<costs.length;i++){
            if(costs[i]<=coins){
                sum+=costs[i];
                count++;
                coins-=costs[i];
            }
        }
        return count;
    }
}