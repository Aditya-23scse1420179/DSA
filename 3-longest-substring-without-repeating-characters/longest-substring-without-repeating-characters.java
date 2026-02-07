class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>map=new HashSet<>();
        int left=0,right=0,maxlen=0;
        while(right<s.length()){
            char c=s.charAt(right);
            while(map.contains(c)){
                map.remove(s.charAt(left));
                left++;
            }
            map.add(c);
            maxlen=Math.max(maxlen,right-left+1);
            right++;
        }
        return maxlen;
    }
}