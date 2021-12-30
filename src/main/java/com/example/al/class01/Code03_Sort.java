package com.example.al.class01;

public class Code03_Sort {

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[j];
		arr[j] = arr[i];
		arr[i] = tmp;
	}

	public static void selectSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int N = arr.length;
		for (int i = 0; i < N; i++) {
			// 0 ~ n-1 选一个最小的
			// 1~ n-1 选一个最小的
			int minValueIndex = i;
			for (int j = i + 1; j < N; j++) {
				minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
			}
			swap(arr, i, minValueIndex);
		}
	}

	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int N = arr.length;
		// 0 -n-1
		// 0 -n-2
		// 0 -n-3
		for (int end = N - 1; end >= 0; end--) {
			for (int second = 1; second <= end; second++) {
				// 第一个 比 第二大 则 交换
				if (arr[second - 1] > arr[second]) {
					swap(arr, second - 1, second);
				}
			}
		}
	}

	// 0 - 1范围有序
	// 0 - n范围有序 整理牌堆
	public static void insertSort1(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int N = arr.length;
		for (int end = 1; end < N; end++) {
			int newNumIndex = end;
			while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]) {
				swap(arr, newNumIndex - 1, newNumIndex);
				newNumIndex--;
			}
		}
	}

	public static void insertSort2(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int N = arr.length;
		for (int end = 1; end < N; end++) {
			for (int pre = end - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
				swap(arr, pre, pre + 1);
			}
		}
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 7, 1, 3, 5, 1, 6, 8, 1, 3, 5, 7, 5, 6 };
		printArray(arr);
		selectSort(arr);
		printArray(arr);
	}

}
