class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        char[] firstHalf = s.substring(0, n/2).toCharArray();
        char[] secondHalf = s.substring((n+1)/2).toCharArray(); // skip middle if odd
        Arrays.sort(firstHalf);
        Arrays.sort(secondHalf);
        StringBuilder sb = new StringBuilder();
        for (char c : firstHalf) sb.append(c);
        if (n % 2 == 1) {
            sb.append(s.charAt(n/2));
        }
        for (int i = secondHalf.length - 1; i >= 0; i--) {
            sb.append(secondHalf[i]);
        }
        return sb.toString();
    }
}
