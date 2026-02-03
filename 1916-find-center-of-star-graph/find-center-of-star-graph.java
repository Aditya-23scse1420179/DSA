class Solution {
    public int findCenter(int[][] edges) {
        int []freq=new int [edges.length+2];
        for(int i=0;i<edges.length;i++){
            freq[edges[i][0]]++;
            freq[edges[i][1]]++;
        }
        int max=0;
        int maxfreq=0;
        for(int i=0;i<freq.length;i++){
            if(freq[i]>maxfreq){
                maxfreq=freq[i];
                max=i;
            }
        }
        return max;
    }
}