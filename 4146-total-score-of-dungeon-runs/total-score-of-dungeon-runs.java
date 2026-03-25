class Solution {
    public long totalScore(long hp, int[] damage, int[] requirement) {
        int n = damage.length;
        List<Integer[]> list = new ArrayList<>(); // will store 2 values 0 -> required-power and 1 -> index
        int power = 0;
        for(int i=0;i<n;i++) {
            power += damage[i];
            list.add(new Integer[]{power + requirement[i], i});
        }

        Collections.sort(list, (l1, l2) -> Integer.compare(l1[0], l2[0])); // will sort according to the required-power

        long res = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(); // queue to handle index count
        for(int i=0, j=0;i<n;i++) {
            while(j < n && list.get(j)[0] <= hp) { // loop will continue until health-power (hp) >= power-required
                if(list.get(j)[1] >= i) {
                    q.add(list.get(j)[1]); // add only whose index >= i, anyway it does not matter because later we will remove it if any index < i.
                }
                j++;
            }
            while(!q.isEmpty() && q.peek() < i) q.poll(); // to ignore all indexes which are less that i because we are storing the result for index i
            res += q.size(); // all the valid indexes count
            // increase the health-power (instead of decreasing the damage in prefix sum of list, we will increase hp) 
            // because list.get(j)[1] - damage[i] >= hp is equal to list.get(j)[1] >= hp + damage[i]
            hp += damage[i];  
        }
        return res;
    }
}