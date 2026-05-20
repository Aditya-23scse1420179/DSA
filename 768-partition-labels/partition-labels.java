class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer>ans=new ArrayList<>();
        int i=0;
        while(i<s.length()){
            int end=s.lastIndexOf(s.charAt(i));
            int j=i;
            while(j<end){
                end=Math.max(end,s.lastIndexOf(s.charAt(j)));
                j++;
            }
            ans.add(end-i+1);
            i=end+1;
        }
        return ans;
    }
}