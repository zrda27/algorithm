package com.zrd.study.algorithm.sort;

public class BubbleSort {
	public static void main(String[] args) {
		int[] nums = new int[]{132, 333, 5421, 11, 3242, 11, 344, 523, 5532, 1};
		
		for(int i=0, len=nums.length; i<len; i++){
			for(int j=0; j<len-i-1; j++){
				if(nums[j] < nums[j+1]){
					int tmp = nums[j+1];
					nums[j+1] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		
		for(int n: nums){
			System.out.println(n);
		}
	}
}
