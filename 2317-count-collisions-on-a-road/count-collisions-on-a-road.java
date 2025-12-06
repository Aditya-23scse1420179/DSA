class Solution {
    public int countCollisions(String diff) {
        int n = diff.length();
        int left=0;
        while(left<n&&diff.charAt(left)=='L'){
            left++;
        }
        int right=n-1;
        while(right>=0&&diff.charAt(right)=='R'){
            right--;
        }
        int ans =0;
        while(left<=right){
            if(diff.charAt(left)!='S'){
                ans++;
            }
            left++;
        }
        return ans ;
    }
}