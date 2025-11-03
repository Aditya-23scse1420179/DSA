public class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalCost =0;
        int n =colors.length();
        int maxTimeInGroup=neededTime[0];
        for(int i= 1;i <n;i++){
            if(colors.charAt(i) ==colors.charAt(i-1)){
                totalCost+= Math.min(maxTimeInGroup,neededTime[i]);
                maxTimeInGroup = Math.max(maxTimeInGroup, neededTime[i]);
            }else{
                maxTimeInGroup = neededTime[i];
            }
        }
        return totalCost;
    }
}
