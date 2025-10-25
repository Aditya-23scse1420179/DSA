class Solution {
    public int totalMoney(int n){
        int completeWeeks = n/7;
        int remainingDays = n%7;
        int firstWeekSum = 28;  // 1+2+3+4+5+6+7
        int lastWeekSum = firstWeekSum+7*(completeWeeks -1);
        int sumCompleteWeeks = (firstWeekSum + lastWeekSum) *completeWeeks/2;
        int firstDay =completeWeeks+ 1;
        int lastDay = completeWeeks+remainingDays;
        int sumRemainingDays =(firstDay+lastDay) *remainingDays/2;
        return sumCompleteWeeks+sumRemainingDays;
    }
}
