package test;

import java.util.*;

public class IceCreamParlor {
	public static void main(String[] args) {
		System.out.println("Hello World");
		Scanner scanner = new Scanner(System.in);
		int d = scanner.nextInt();
		for (int p = 0; p < d; p++) {
			int money = scanner.nextInt();
			int n = scanner.nextInt();
			int[] menu = new int[n];
			for (int i = 0;i < n; i++) {
				menu[i] = scanner.nextInt();
			}
			Arrays.sort(menu);
			
			int[] cost = menu;
			System.out.println(cost.length + " " +  cost[0] + " " + Arrays.asList(cost).indexOf(2));
			indexOf(2, menu);
			printArray(cost);
			
			for (int i = 0; i < n; i++) {
				int price = menu[i];
				int complement = money - price;
				if (binarySearch(menu, complement, -1, 0, n-1) != -1) {
					int priceIndex = Arrays.asList(cost).indexOf(price);
					int compIndex = Arrays.asList(cost).indexOf(complement);
					System.out.println(priceIndex + " " + compIndex);
					break;
				}
			}
			
		}
	}
	
	private static void printArray(int[] a) {
		for (int e : a) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
	
	public static int binarySearch(int[] a, int value, int index, int left, int right) {
		if (left <= right) {
			int midIndex = left + (right - left) / 2;
			if (value == a[midIndex]) {
				index = midIndex;
				return index;
			} else if (value < a[midIndex]) {
				right = midIndex - 1;
			} else {
				left = midIndex + 1;
			}
			index = binarySearch(a, value, index, left, right);
		}
		return index;
	}
}