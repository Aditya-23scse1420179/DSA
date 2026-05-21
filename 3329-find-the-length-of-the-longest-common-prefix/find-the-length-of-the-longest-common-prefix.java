class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String>set=new HashSet<>();
        //all prefix of arr1
        for(int a:arr1){
            String n=a+"";
            String pre="";
            for(int i=0;i<n.length();i++){
                pre+=n.charAt(i);
                set.add(pre);
            }
        }
        int max=0;
        // check all possible pre of arr2
        for(int b:arr2){
            String n=b+"";
            String pre="";
            for(int i=0;i<n.length();i++){
                pre+=n.charAt(i);
                if(set.contains(pre)){
                    max=Math.max(max,pre.length());
                }
            }
        }
        return max;
        
    }
}