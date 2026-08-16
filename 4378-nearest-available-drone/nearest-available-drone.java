class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int idx=-1;
        int min=(int)1e9;
        for(int i=0;i<drones.length;i++){
            int x=drones[i][0];
            int y=drones[i][1];
            int r=drones[i][2];
            if((Math.abs(x-target[0])+Math.abs(y-target[1]))<=r){
                if(Math.abs(x-target[0])+Math.abs(y-target[1])<min){
                    min=Math.min(min,Math.abs(x-target[0])+Math.abs(y-target[1]));
                    idx=i;
                }
            }
        }
        return idx;
    }
}