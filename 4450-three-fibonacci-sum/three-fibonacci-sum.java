class Solution {
    public boolean threeFibonacciSum(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        while (true) {
            int next = list.get(list.size() - 1) + list.get(list.size() - 2);
            if (next > n) break;
            list.add(next);
        }
        for (int i = 0; i <= list.size() - 3; i++) {
            int sum = list.get(i) + list.get(i + 1) + list.get(i + 2);
            if (sum == n) {
                return true;
            }
        }
        
        return false;
    }
}