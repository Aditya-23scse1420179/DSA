class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits) count[d]++;
        List<Integer> result = new ArrayList<>();
        for (int num = 100; num < 1000; num += 2) {
            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;
            if (a == 0) continue;
            int[] req = new int[10];
            req[a]++;
            req[b]++;
            req[c]++;
            boolean ok = true;
            for (int d = 0; d < 10; d++) {
                if (req[d] > count[d]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                result.add(num);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
