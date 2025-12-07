class Solution {
    public int[] asteroidCollision(int[] ass) {
        Stack <Integer>st= new Stack<>();
        for(int x:ass){
            boolean collide=false;
            while(!st.isEmpty()&&x<0&&st.peek()>0){
                if(st.peek()<-x){
                    st.pop();
                    continue;
                }else if(st.peek()==-x){
                    st.pop();
                }
                collide=true;
                break;
            }
            if(!collide){
                st.push(x);
            }
        }
        int []ans = new int [st.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans ;

    }
}
