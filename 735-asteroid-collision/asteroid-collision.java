class Solution {
    public int[] asteroidCollision(int[] ass) {
        Stack<Integer>st=new Stack<>();
        for(int a:ass){
            if(a>0){
                st.add(a);
            }else{
                while(!st.isEmpty()&&st.peek()>0&&st.peek()<Math.abs(a)){
                    st.pop();
                }
                if(!st.isEmpty()&&st.peek()>0&&st.peek()==Math.abs(a)){
                    st.pop();
                    continue;
                }
                if(st.isEmpty()||st.peek()<0){
                    st.push(a);
                }
            }
        }
        int size=st.size();
        int[]ans=new int[size];
        for(int i=size-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}