package test;

public class Sieve {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Sieve s = new Sieve();
		s.sieve(500);
	}
	
	public void sieve(int n) {
		boolean[] a = new boolean[n];
		
		for (int i = 2; i < Math.sqrt(n); i++) {
			for (int j = i*i; j < n; j += i) {
				a[j] = true;
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (a[i]) {
				System.out.println(primality(i));
			}
		}
		
		System.out.println();
	}
	
	public static String primality(int n) {
		if (n == 1) {
			return "Not prime";
		}
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return "Not prime";
			}
		}
		
		return "Prime";
	}
}
