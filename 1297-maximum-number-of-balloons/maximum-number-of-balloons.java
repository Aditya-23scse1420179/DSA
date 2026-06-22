class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer>map=new HashMap<>();
        for(char ch:text.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }int ans=Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int freq = entry.getValue();

            if (ch == 'a') {
                ans = Math.min(ans, freq);
            }
            if (ch == 'b' && ans != Integer.MAX_VALUE) {
                ans = Math.min(ans, freq);
            }
            if (ch == 'l' && ans != Integer.MAX_VALUE) {
                ans = Math.min(ans, freq / 2);
            }
            if (ch == 'n' && ans != Integer.MAX_VALUE) {
                ans = Math.min(ans, freq);
            }
            if (ch == 'o' && ans != Integer.MAX_VALUE) {
                ans = Math.min(ans, freq / 2);
            }
        }

        return ans != Integer.MAX_VALUE ? ans : 0;
    }
}