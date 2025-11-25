class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String>ot = new ArrayList<>();
        int i=0;
        int nums =1;
        while(i<target.length){
            if(nums==target[i]){
                ot.add("Push");
                i++;
            }else{
                ot.add("Push");
                ot.add("Pop");
            }
            nums++;
        }
        return ot;
    }
}