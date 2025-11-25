class Solution {
    public int lastRemaining(int n) {
        return helper(1,1,n,true);
        
    }
    public int helper(int head,int steps,int remain,boolean left ){
        if(remain==1)return head;
        if(left || remain%2==1){
            head =head+steps;
        }
        remain =remain/2;
        steps=steps*2;
        return helper(head,steps,remain,!left);
    }
}