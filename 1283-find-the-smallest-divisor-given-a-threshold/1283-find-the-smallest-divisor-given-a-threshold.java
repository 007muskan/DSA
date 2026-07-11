class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(num, max);
        }

        int low = 1;
        int high = max;
        int ans = 0;

        while(low <= high){
            int mid = low+(high-low)/2;
            if(isPossible(nums,threshold,mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    static boolean isPossible(int[] nums, int threshold, int divisor){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += (nums[i]+divisor-1)/divisor;
        }

        return sum <= threshold;
    }
}