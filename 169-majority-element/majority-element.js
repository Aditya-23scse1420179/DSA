/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    let map=new Map();
    for (let num of nums){
        map.set(num,(map.get(num)||0)+1);
    }
    let freq=0;
    let ans=nums[0];
    for(let a of map.keys()){
        if(map.get(a)>freq){
            freq=map.get(a);
            ans=a;
        }
    }
    return ans;
};