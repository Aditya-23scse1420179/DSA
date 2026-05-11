class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for(int i=0 ; i<nums.length ; i++){
            int num = nums[i];
            while(num>0){
                st.push(num%10);
                num /= 10;
            }
            while(!st.isEmpty()){
                ans.add(st.pop());
            }
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result; 
    }
}