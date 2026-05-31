class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n=asteroids.length;
        Arrays.sort(asteroids);
        long ans=0;
        ans=mass;
        // else return false;
        for(int i=0;i<n;i++){
            if(ans>=asteroids[i]){
                ans+=asteroids[i];
            }else return false;
        }
        return true;
    }
}