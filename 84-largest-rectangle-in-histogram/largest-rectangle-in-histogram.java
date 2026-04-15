class Solution {
    public int largestRectangleArea(int[] h) {
        int max=0;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<=h.length;i++){
            int currh=(i==h.length)?0:h[i];
            while(!st.isEmpty()&&currh<h[st.peek()]){
                int height=h[st.pop()];
                int w=st.isEmpty()?i:i-st.peek()-1;
                max=Math.max(height*w,max);
            }
            st.push(i);
        }
        return max;
    }
}