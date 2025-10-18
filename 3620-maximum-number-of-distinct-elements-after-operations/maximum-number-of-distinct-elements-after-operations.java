import java.util.*;

public class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int distinctCount= 0;
        long prev =Long.MIN_VALUE;  
        for (int x:nums) {
            long low =(long)x-k;
            long high=(long)x +k;
            long want=Math.max(low,prev+1);
            long cur=Math.min(high,want);
            if (cur>prev) {
                distinctCount++;
                prev=cur;
            }
        }
        return distinctCount;
    }
}
