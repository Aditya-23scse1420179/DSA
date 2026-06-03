class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int free=0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0)free+=customers[i];
        }
        int slide=0;
        for(int i=0;i<minutes;i++){
            if(grumpy[i]==1)slide+=customers[i];
        }
        int ans=slide;
        for(int i=minutes;i<customers.length;i++){
            if(grumpy[i]==1)slide+=customers[i];
            if(grumpy[i-minutes]==1)slide-=customers[i-minutes];
            ans=Math.max(ans,slide);
        }
        return free+ans;
    }
}