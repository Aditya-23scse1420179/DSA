class Solution {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer>st=new Stack<>();
        st.add((int)1e9);
        int ans=0;
        for(int a:arr){
            while(st.peek()<=a){
                ans+=st.pop()*Math.min(st.peek(),a);
            }
            st.push(a);
        }
        while(st.size()>2){
            ans+=st.pop()*st.peek();
        }
        return ans;
    }
}