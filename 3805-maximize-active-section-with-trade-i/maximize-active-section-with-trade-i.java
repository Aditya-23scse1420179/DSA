class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n=s.length();
        
        int c1=0;
        for(int a:s.toCharArray()){
            if(a=='1')c1++;
        }
        List<Integer>list=new ArrayList<>();
        int i=0;
        while(i<n){
            if(s.charAt(i)=='0'){
                int count=0;
                while(i<n&&s.charAt(i)=='0'){
                    count++;
                    i++;
                }
                list.add(count);
            }else{
                i++;
            }
        }int max=0;
        for(int x=0;x<list.size()-1;x++){
            max=Math.max(max,list.get(x)+list.get(x+1));
        }
        return max+c1;
    }
}