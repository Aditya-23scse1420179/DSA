class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        Arrays.sort(arr);
        int min=(int)1e9;
        for(int i=1;i<arr.length;i++){
            int diff=Math.abs(arr[i]-arr[i-1]);
            min=Math.min(min,diff);
        }int n=arr.length;
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=1;i<n;i++){
            // for(int j=i+1;j<n;j++){
               if(Math.abs(arr[i]-arr[i-1])==min){
                    ans.add(Arrays.asList(arr[i-1], arr[i]));
               }
            
        }
        return ans;
    }
}