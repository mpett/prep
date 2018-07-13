package test;

public class Hello {
	public static void main(String[] args) {
		System.out.println("Hello World");
		int[] a = {191,81,817,5,8,8,81,98171,516517,5};
		printArray(a);
		Hello o = new Hello();
		o.quicksort(a, 0, a.length -1);
		printArray(a);
	}
	
	public static void printArray(int[] a) {
		for (int e : a) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
	
	public void quicksort(int[] a, int lo, int hi) {
		if (lo < hi) {
			int p = partition(a, lo, hi);
			quicksort(a, p + 1, hi);
			quicksort(a, lo, p - 1);
		}
	}
	
	public int partition(int[] a, int lo, int hi) {
		int pivot = a[hi];
		int i = lo - 1;
		
		for (int j = lo; j < hi; j++) {
			if (a[j] < pivot) {
				i++;
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}
		
		int tmp = a[i+1];
		a[i+1] = a[hi];
		a[hi] = tmp;
		
		return i+1;
	}
}
