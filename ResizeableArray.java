package test;

public class ResizeableArray {
	int size;
	int[] items;
	
	public ResizeableArray(int size) {
		this.size = size;
		items = new int[size];
	}
	
	public int size() {
		return size;
	}
	
	public void set(int index, int item) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		items[index] = item;
	}
	
	public void append(int item) {
		ensureExtraCapacity();
		items[size] = item;
		size++;
	}
	
	public int get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return items[index];
	}
	
	public void ensureExtraCapacity() {
		if (size == items.length) {
			int[] tmp = new int[size * 2];
			System.arraycopy(items, 0, tmp, 0, size);
			items = tmp;
		}
	}
}
