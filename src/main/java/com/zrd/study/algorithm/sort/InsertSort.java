package com.zrd.study.algorithm.sort;

public class InsertSort {
	public static void main(String[] args) {
		int[] nums = new int[]{2, 33, 12, 4, 2, 1, 4, 5, 32, 0, 34, 99, 999999999};
		int[] results = new int[nums.length];
		
		for(int i=0, len=nums.length; i< len; i++){
			boolean inserted = false;
			for(int j=0; j<i-1; j++){
				if(nums[i] < results[j]){
					for(int k = i; k > j; k--){
						results[k] = results[k - 1];
					}
					results[j] = nums[i];
					inserted = true;
					break;
				}
			}
			if(!inserted){
				results[i] = nums[i];
			}
		}
		
		for(int n: results){
			System.out.println(n);
		}
	}
}
