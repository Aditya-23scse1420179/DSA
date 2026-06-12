class Solution {
    public int heightChecker(int[] heights) {
        int[]expect=new int[heights.length];
        int max=-(int)1e9;
        int min=(int)1e9;
        for(int a:heights){
            max=Math.max(a,max);
            min=Math.min(a,min);
        }
        int[]freq=new int[max-min+1];
        for(int a:heights){
            freq[a-min]++;
        }
        int idx=0;
        for(int i=0;i<freq.length;i++){
            while(freq[i]>0){
                expect[idx++]=i+min;
                freq[i]--;
            }
        }

        int count=0;
        for(int i=0;i<heights.length;i++){
            if(heights[i]!=expect[i])count++;
        }
        return count;
    }
}