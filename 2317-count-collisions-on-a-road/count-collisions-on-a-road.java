class Solution {
    public int countCollisions(String diff) {
        boolean left=false;
        int rightIdx=-1;
        int count=0;
        if(!diff.contains("R") && !diff.contains("S"))return 0;
        if(!diff.contains("L") && !diff.contains("S"))return 0;
        for(int i=diff.length()-2;i>=0;i--){
            if(diff.charAt(i)=='R' && diff.charAt(i+1)=='L'){
                rightIdx=i;
                break;
            }
        }
        for(int i=0;i<diff.length();i++){
            if(i<diff.length()-1 && diff.charAt(i)=='R' && diff.charAt(i+1)=='L'){
                count+=2;
                left=true;
                i++;
                continue;
            }
            if(diff.charAt(i)=='L' && (left||diff.substring(0,i).contains("S"))){
                count++;
                left=true;
                continue;
            }
            if(diff.charAt(i)=='R' && (rightIdx>i|| diff.substring(i+1).contains("S")))count++;


        }
        return count;
    }
}

/*class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int left = 0;
        while(left < n && directions.charAt(left) == 'L')
            left++;

        int right = n-1;
        while(right >= 0 && directions.charAt(right) == 'R')
            right--;

        int ans = 0;

        while(left <= right){
            if(directions.charAt(left) != 'S')
                ans++;
            left++;
        }
        return ans;
        
    }
}*/