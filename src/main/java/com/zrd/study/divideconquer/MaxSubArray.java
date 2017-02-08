package com.zrd.study.divideconquer;

/**
 * Created by zrd on 2017/2/8.
 */
public class MaxSubArray {
    public static void main(String[] args) {
        double[] nums = new double[]{-1.2, -2.3, 8, 1, 3, 4, 2, -2, 1,
                15, -22, -2, -1, 1, 3, 4};
        System.out.println(getMaxSubArray(nums, 0, nums.length - 1));
    }

    public static SubArray getMaxSubArray(double[] nums, int left, int right){
        if(left == right){
            return new SubArray(left, left, nums[left]);
        }
        int mid = (left + right) / 2;
        SubArray midMaxSubArray = getMaxSubArrayWithMid(nums, left, mid, right);
        SubArray leftMaxSubArray = getMaxSubArray(nums, left, mid);
        SubArray rightMaxSubArray = getMaxSubArray(nums, mid + 1, right);

        if(leftMaxSubArray.compareTo(midMaxSubArray) >= 0
                && leftMaxSubArray.compareTo(rightMaxSubArray) >= 0){
            return leftMaxSubArray;
        }
        if(midMaxSubArray.compareTo(leftMaxSubArray) >= 0
                && midMaxSubArray.compareTo(rightMaxSubArray) >= 0){
            return midMaxSubArray;
        }
        if(rightMaxSubArray.compareTo(midMaxSubArray) >= 0
                && rightMaxSubArray.compareTo(rightMaxSubArray) >= 0){
            return rightMaxSubArray;
        }
        return null;
    }

    public static SubArray getMaxSubArrayWithMid(double[] nums, int left, int mid, int right){
        double leftMaxSum = nums[mid];
        int low = mid;

        double sum = 0;
        for(int i = mid; i>= left; i--){
            sum += nums[i];
            if(sum > leftMaxSum){
                low = i;
                leftMaxSum = sum;
            }
        }
        double rightMaxSum = nums[mid];
        sum = 0;
        int high = mid;
        for(int i = mid+1; i<= right; i++){
            sum += nums[i];
            if(sum > rightMaxSum){
                high = i;
                rightMaxSum = sum;
            }
        }
        return new SubArray(low, high, leftMaxSum + rightMaxSum - nums[mid]);
    }

}

class SubArray implements Comparable<SubArray>{
    private int start;
    private int end;
    private double value;

    SubArray(int start, int end, double value){
        this.start = start;
        this.end = end;
        this.value = value;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "start:" + start + "\r\nend:" + end + "\r\nvalue:" + value;
    }

    @Override
    public int compareTo(SubArray o) {
        if(this.getValue() > o.getValue()){
            return 1;
        }else if(this.getValue() == o.getValue()){
            return 0;
        }else{
            return -1;
        }
    }
}
