import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result =new ArrayList<>();
        result.add(words[0]); 
        for (int i = 1; i < words.length; i++) {
            String curr=words[i];
            String prev=result.get(result.size() -1);
            if (!isAnagram(curr, prev)) {
                result.add(curr);
            }
        }
        return result;
    }
    private boolean isAnagram(String a, String b) {
        if (a.length()!=b.length()) return false;
        char[] ch1= a.toCharArray();
        char[] ch2 =b.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1,ch2);
    }
}
