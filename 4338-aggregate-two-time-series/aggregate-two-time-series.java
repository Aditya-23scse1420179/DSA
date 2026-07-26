class Solution {
    public  List<List<Integer>>aggregateTimeSeries(int[][] s1, int[][] s2) {
        List<List<Integer>>ans=new ArrayList<>();
        int i=0,j=0;
        while(i<s1.length&&j<s2.length){
            if(s1[i][0]==s2[j][0]){
                ans.add(Arrays.asList(s1[i][0],s2[j][1]+s1[i][1]));
                i++;j++;
            }else if(s1[i][0]<s2[j][0]){
                ans.add(Arrays.asList(s1[i][0],s1[i][1]+s2[j][1]));
                i++;
            }else{
                ans.add(Arrays.asList(s2[j][0],s1[i][1]+s2[j][1]));
                j++;
            }
        }
        while(j<s2.length){
            ans.add(Arrays.asList(s2[j][0],0+s2[j][1]));
            j++;
        }
        while(i<s1.length){
            ans.add(Arrays.asList(s1[i][0],0+s1[i][1]));
            i++;
        }
        return ans;
    }
}