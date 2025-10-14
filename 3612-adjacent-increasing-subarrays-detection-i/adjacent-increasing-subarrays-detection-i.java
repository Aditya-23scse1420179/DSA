class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> arr, int k) {
        int n = arr.size();
        if (n <2*k) return false;
        for (int i=0; i<=n-2*k; i++) {
            if (isIncreasing(arr,i,k) && isIncreasing(arr,i +k, k)) {
                return true;
            }
        }
        return false;
    }
    private boolean isIncreasing(List<Integer> arr, int start, int k) {
        for (int i =start; i< start +k-1;i++) {
            if (arr.get(i)>= arr.get(i+1)) return false;
        }
        return true;
    }
}
