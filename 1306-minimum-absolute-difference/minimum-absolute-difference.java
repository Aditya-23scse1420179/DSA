class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int max = arr[0], min = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        int range = max - min + 1;
        int[] count = new int[range];

        for (int num : arr) {
            count[num - min]++;
        }
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                arr[index++] = i + min;
                count[i]--;
            }
        }
        // Arrays.sort(arr);
        int mini=(int)1e9;
        for(int i=1;i<arr.length;i++){
            int diff=Math.abs(arr[i]-arr[i-1]);
            mini=Math.min(mini,diff);
        }int n=arr.length;
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=1;i<n;i++){
            // for(int j=i+1;j<n;j++){
               if(Math.abs(arr[i]-arr[i-1])==mini){
                    ans.add(Arrays.asList(arr[i-1], arr[i]));
               }
            
        }
        return ans;
    }
}