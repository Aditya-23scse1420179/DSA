class Solution {
    public int minNumberOperations(int[] target) {
        int passes = target[0];
        for(int i=1;i<target.length;i++){
            if(target[i-1]<target[i]){
                passes+=(target[i]-target[i-1]);
            }
        }
        return passes;
        
    }
}