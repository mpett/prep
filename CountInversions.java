package test;

import java.util.*;

public class CountInversions {
	private static int inv = 0;
	
	public static void main(String[] args) {
		System.out.println("Hello World");
		handleInput();
	}
	
	public static void handleInput() {
		Scanner scanner = new Scanner(System.in);
		int d = scanner.nextInt();
		
		for (int i = 0; i < d; i++) {
			int n = scanner.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = scanner.nextInt();
			}
			System.out.println(countInversions(arr));
		}
	}
	
	private static long countInversions(int[] arr) {
		long numInversions = 0;
		quickCount(arr, 0, arr.length - 1);
		numInversions = inv;
		return numInversions;
	}
	
	private static void quickCount(int[] a, int lo, int hi) {
		if (lo < hi) {
			int p = partition(a, lo, hi);
			quickCount(a, p + 1, hi);
			quickCount(a, lo, p - 1);
		}
	}
	
	private static int partition(int[] a, int lo, int hi) {
		int pivot = a[hi];
		int i = lo - 1;
		
		for (int j = lo; j < hi; j++) {
			if (a[j] < pivot) {
				i++;
				inv++;
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				
			}
		}
		
		inv++;
		int tmp = a[i+1];
		a[i+1] = a[hi];
		a[hi] = tmp;
		
		return i+1;
		
	}
}
