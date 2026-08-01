class Solution {
    public String winningPlayer(int x, int y) {
        int move=Math.min(x,y/4);
        if(move%2==1){
            return "Alice";
        }
        return "Bob";
    }
}