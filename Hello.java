package test;

public class Hello {
	public static void main(String[] args) {
		System.out.println("Hello World");
		int[] a = {165181,17,15,17,1,1,15,168,181,98,118};
		printArray(a);
		Hello o = new Hello();
		o.heapsort(a);
		printArray(a);
	}
	
	public static void printArray(int[] a) {
		for (int e : a) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
	
	public void heapsort(int[] a) {
		int n = a.length;
		
		for (int i = n/2-1; i >= 0; i--)  {
			heapify(a, n, i);
		}
		
		for (int i = n-1; i >= 0; i--) {
			int tmp = a[0];
			a[0] = a[i];
			a[i] = tmp;
			heapify(a, i, 0);
		}
	}
	
	public void heapify(int[] a, int n, int i) {
		int hi = i;
		int l = 2*i+1;
		int r = 2*i+2;
		
		if (l < n && a[l] > a[hi]) {
			hi = l;
		}
		
		if (r < n && a[r] > a[hi]) {
			hi = r;
		}
		
		if (hi != i) {
			int tmp = a[i];
			a[i] = a[hi];
			a[hi] = tmp;
			heapify(a, n, hi);
		}
	}
}
