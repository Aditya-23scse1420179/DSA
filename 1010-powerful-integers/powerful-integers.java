class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<=20;i++){
            int a=(int)Math.pow(x,i);
            if(a>bound)break;
            for(int j=0;j<=20;j++){
                int b=(int)Math.pow(y,j);
                if(a+b<=bound){
                    set.add(a+b);
                }else{
                    break;
                }
            }

        }
        return new ArrayList(set);
    }
}