class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = Integer.MIN_VALUE;
        int max = 0;
        for(int w : weights){
            max += w;
            min = Math.max(min,w);
        }
        int low = min;
        int high = max;
        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(isPossible(weights,days, mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    static boolean isPossible(int[] weights, int days, int capacity){
        int daysUsed = 1;
        int currentLoad = 0;
        for(int i=0;i<weights.length;i++){
            if(currentLoad + weights[i] <= capacity){
                currentLoad += weights[i];
            }else{
                daysUsed++;
                currentLoad = weights[i];
            }
        }
        return daysUsed <= days;
    }
}