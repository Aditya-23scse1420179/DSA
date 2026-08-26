class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left=0,one=0;
        String res="";
        // ArrayList<Integer>list=new ArrayList<>();
        for(int right=0;right<s.length();right++){
            if(s.charAt(right)=='1'){
                one++;
            }
            while(one>k||(one==k&&left<=right&&s.charAt(left)=='0')){
                if(s.charAt(left)=='1')one--;
                left++;
            }
            if(one==k){
                String curr=s.substring(left,right+1);
                if(res.equals("")||curr.length()<res.length()||(curr.length()==res.length()&&curr.compareTo(res)<0)){
                    res=curr;
                }
            }
        }
        return res;
    }
}