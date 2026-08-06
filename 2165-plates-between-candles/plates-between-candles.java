class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[]l=new int[s.length()];
        int[]r=new int[s.length()];
        int[]pre=new int[s.length()];
        l[0]=s.charAt(0)=='|'?0:-1;
        pre[0]=s.charAt(0)=='*'?1:0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='*'){
                l[i]=l[i-1];
            }else{
                l[i]=i;
            }
            if(s.charAt(i)=='*'){
                pre[i]=pre[i-1]+1;
            }else{
                pre[i]=pre[i-1];
            }
        }
        r[s.length()-1]=(s.charAt(s.length()-1)=='|'?s.length()-1:-1);;
        for(int i=s.length()-2;i>=0;i--){
             if(s.charAt(i)=='*'){
                r[i]=r[i+1];
            }else{
                r[i]=i;
            }
        }int[]arr=new int[queries.length];
        int id=0;
        for(int[]x:queries){
            int a=r[x[0]];
            int b=l[x[1]];
            if(a==-1||b==-1||a>=b)arr[id++]=0;
            else arr[id++]=pre[b]-pre[a];
        }
        return arr;

    }
}