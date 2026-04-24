class Solution {
    public boolean closeStrings(String w1, String w2) {
        int n=w1.length();
        int m=w2.length();
        if(n!=m)return false;
        Set<Character>set1=new HashSet<>();
        for(char ch:w1.toCharArray())set1.add(ch);
        Set<Character>set2=new HashSet<>();
        for(char a:w2.toCharArray())set2.add(a);
        if(!set1.equals(set2))return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (char ch : w1.toCharArray()) freq1[ch - 'a']++;
        for (char ch : w2.toCharArray()) freq2[ch - 'a']++;

        // convert to lists (your style)
        List<Integer> ans = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        for (int f : freq1) if (f > 0) ans.add(f);
        for (int f : freq2) if (f > 0) ans2.add(f);
        Collections.sort(ans);
        Collections.sort(ans2);
        return ans.equals(ans2);
    }
}