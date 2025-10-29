class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        while (i < n && s.charAt(i)== ' ') i++;
        if (i == n) return 0;
        int sign =1;
        char ch =s.charAt(i);
        if(ch =='+' || ch == '-'){
            sign = (ch =='-')?-1 : 1;
            i++;
        }
        int result = 0;
        int maxLimit = Integer.MAX_VALUE / 10;
        int maxDigit = Integer.MAX_VALUE % 10;
        while(i <n){
            ch = s.charAt(i);
            if(ch< '0'||ch > '9') break;
            int digit = ch -'0';
            if (result >maxLimit ||(result ==maxLimit&&digit > maxDigit)) {
                return (sign== -1) ? Integer.MIN_VALUE: Integer.MAX_VALUE;
            }
            result = result*10 +digit;
            i++;
        }
        return result *sign;
    }
}
