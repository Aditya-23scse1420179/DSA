class Solution {
    public int twoEggDrop(int n) {
        int sum = 0, x = 0;
        while (sum < n) {
            x++;
            sum += x;
        }

        return x;
    }
}