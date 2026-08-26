class Solution {
    public int minNumberOfFrogs(String s) {
        int flag=0,max=0,c=0,r=0,o=0,a=0,k=0;
        if(s.length()<10)return -1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='c'){
                c++;
                flag++;
                max=Math.max(max,flag);
            }
            else if(s.charAt(i)=='r'){
                if(r>=c)return -1;
                else r++;
            }
            else if(s.charAt(i)=='o'){
                if(o>=r)return -1;
                else o++;
            }
            else if(s.charAt(i)=='a'){
                if(a>=o)return -1;
                else a++;
            }
            else if(s.charAt(i)=='k'){
                if(k>=a)return -1;
                else k++;
                flag--;
            }
        }
        if(flag==0&&c==r&&r==o&&o==a&&a==k)return max;
        return -1;
    }
}