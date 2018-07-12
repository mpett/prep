package test;

import java.util.*;

public class VectorQuick<E extends Comparable<E>> {
	public static void main(String[] args) {
		System.out.println("Hello World");
		int n = 32;
		Integer[] a = new Integer[n];
		List<Integer> b = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			a[i] = i;
			b.add(i);
		}
		Collections.shuffle(b);
		VectorQuick<Integer> l = new VectorQuick<Integer>(b);
		
	}
	
	public VectorQuick(List<E> list) {
		System.out.println("Unsorted list: " + list);
		quicksort(list);
		System.out.println("Sorted list: " + list);
	}
	
	public void quicksort(List<E> list) {
		List<E> small = new Vector<E>();
		List<E> equal = new Vector<E>();
		List<E> big = new Vector<E>();
		
		if (list.size() > 1) {
			E pivot = list.get(0);
			partition(list, pivot, small, equal, big);
			quicksort(small);
			quicksort(big);
			list.addAll(small);
			list.addAll(equal);
			list.addAll(big);
		}
	}
	
	public void partition(List<E> list, E pivot, List<E> small,
			List<E> equal, List<E> big) {
		while (!list.isEmpty()) {
			E e = list.remove(0);
			
			if (e.compareTo(pivot) > 0) {
				big.add(e);
			} else if (e.compareTo(pivot) < 0) {
				small.add(e);
			} else { // e splitvalue
				equal.add(e);
			}
		}
	}
}
