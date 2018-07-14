package test;

import java.util.*;

public class RunningMedian {
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;
	
	public RunningMedian() {
		this.minHeap = new PriorityQueue<Integer>();
		this.maxHeap = new PriorityQueue<Integer>(10, 
				new MedianComparator());
	}
	
	private void addToList(int sizeOfCurrentList, int value) {
		maxHeap.add(value);
		
		if ((sizeOfCurrentList & 1) == 0) {
			if ((minHeap.isEmpty() == false) 
					&& (maxHeap.peek() > minHeap.peek())) {
				Integer maxHeapRoot = maxHeap.poll();
				Integer minHeapRoot = minHeap.poll();
				minHeap.add(maxHeapRoot);
				maxHeap.add(minHeapRoot);
			}
		} else {
			minHeap.add(maxHeap.poll());
		}
	}
	
	private double findMedian(int sizeOfCurrentList) {
		double maxHeapRoot = maxHeap.peek();
		if ((sizeOfCurrentList & 1) == 0) {
			double minHeapRoot = minHeap.peek();
			return ((maxHeapRoot + minHeapRoot)/2.0);
		} else {
			return maxHeapRoot;
		}
	}
	
	private static class MedianComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		RunningMedian rm = new RunningMedian();
		
		for (int i = 1; i <= n; i++) {
			int value = scanner.nextInt();
			rm.addToList(i-1, value);
			System.out.println(rm.findMedian(i));
		}
		
		scanner.close();
	}
}
