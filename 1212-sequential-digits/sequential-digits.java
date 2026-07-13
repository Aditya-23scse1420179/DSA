class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> s = Arrays.asList(
            // 2-digit
            12, 23, 34, 45, 56, 67, 78, 89,
            // 3-digit
            123, 234, 345, 456, 567, 678, 789,
            // 4-digit
            1234, 2345, 3456, 4567, 5678, 6789,
            // 5-digit
            12345, 23456, 34567, 45678, 56789,
            // 6-digit
            123456, 234567, 345678, 456789,
            // 7-digit
            1234567, 2345678, 3456789,
            // 8-digit
            12345678, 23456789,
            // 9-digit
            123456789
        );
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<s.size();i++){
            if(s.get(i)>=low&&s.get(i)<=high){
                list.add(s.get(i));
            }
        }
        return list;
    }
}