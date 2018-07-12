package test;

public class HeapSort {
	public static void main(String[] args) {
		System.out.println("Hello World");
		int[] a = {12358,8,5,161,58651,17,2,1,1,51651651,8,1,51,5,1,1,1,98};
		HeapSort o = new HeapSort();
		printArray(a);
		o.heapsort(a);
		printArray(a);
	}
	
	public static void printArray(int[] A) {
		for (int element : A) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
	
	public void heapsort(int[] A) {
		int n = A.length;
		
		for (int i = n/2 - 1; i >= 0; i--) {
			heapify(A, n, i);
		}
		
		for (int i = n - 1; i >= 0; i--) {
			int tmp = A[i];
			A[i] = A[0];
			A[0] = tmp;
			heapify(A,i,0);
		}
	}
	
	public void heapify(int[] A, int n, int i) {
		int hi = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		
		if (l < n && A[l] > A[hi]) {
			hi = l;
		}
		
		if (r < n && A[r] > A[hi]) {
			hi = r;
		}
		
		if (hi != i) {
			int tmp = A[i];
			A[i] = A[hi];
			A[hi] = tmp;
			heapify(A, n, hi);
		}
	}
}
