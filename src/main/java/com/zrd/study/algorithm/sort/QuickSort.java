package com.zrd.study.algorithm.sort;

public class QuickSort {
	public static void main(String[] args) {
		int[] nums = new int[]{2, 33, 12, 4, 2, 1, 4, 5, 32, 0, 34, 99, 999999999};
		
		nums = sort(nums, 0, nums.length - 1);
		
		for(int n: nums){
			System.out.println(n);
		}
	}
	
	public static int[] sort(int[] nums, int left, int right){
		if(left > right){
			return nums;
		}
		int i = left;
		int j = right;
		int tmp = nums[left];
		
		while(i != j){
			while(nums[j] <= tmp && i < j){
				j --;
			}
			while(nums[i] >= tmp && i < j){
				i ++;
			}
			if(i < j){
				int t = nums[i];
				nums[i] = nums[j];
				nums[j] = t;
			}
		}
		
		nums[left] = nums[i];
		nums[i] = tmp;
		
		nums = sort(nums, left, i - 1);
		nums = sort(nums, i + 1, right);
		
		return nums;
	}
}
