class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String>ans=new ArrayList<>();
        int n=words.length;
        int i=0;
        while(i<n){
            int j=i;
            int letter=0;
            while(j<n&&letter+words[j].length()+(j-i)<=maxWidth){
                letter+=words[j].length();
                j++;
            }
            int count=j-i;
            StringBuilder sb=new StringBuilder();
            if(j==n||count==1){
                for(int k=i;k<j;k++){
                    sb.append(words[k]);
                    if(k!=j-1){
                        sb.append(" ");
                    }
                }
                while(sb.length()<maxWidth){
                    sb.append(" ");
                }
            }else{

                int spaces = maxWidth - letter;
                int gaps = count - 1;
                int base = spaces / gaps;
                int extra = spaces % gaps;
                for (int k = i; k < j - 1; k++) {
                    sb.append(words[k]);
                    int currentGap = base;
                    if (extra > 0) {
                        currentGap++;
                        extra--;
                    }
                    for (int s = 0; s < currentGap; s++)
                        sb.append(" ");
                }
                sb.append(words[j - 1]);
            }
            ans.add(sb.toString());
            i = j;
        }
        return ans;
    }
}