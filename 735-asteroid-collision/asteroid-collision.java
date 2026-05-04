class Solution {
    public int[] asteroidCollision(int[] ass) {
            List<Integer> list = new ArrayList<>();
    for (int x : ass) list.add(x);

    boolean changed = true;
    while (changed) {
        changed = false;
        for (int i = 0; i < list.size() - 1; i++) {
            int a = list.get(i), b = list.get(i+1);
            if (a > 0 && b < 0) { // collision
                if (Math.abs(a) > Math.abs(b)) {
                    list.remove(i+1); // remove b
                } else if (Math.abs(a) < Math.abs(b)) {
                    list.remove(i);   // remove a
                } else {
                    list.remove(i+1);
                    list.remove(i);
                }
                changed = true;
                break; // restart loop
            }
        }
    }

    // convert list back to array
    int[] res = new int[list.size()];
    for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
    return res;

    }
}
