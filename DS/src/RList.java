import java.util.ArrayList;
import java.util.List;

public class RList<T> {
	final int DEFAULT_SIZE = 5;
	final int multiplier = 2;
	private int internalSize = DEFAULT_SIZE;
	T[] list;
	int size;
	public RList() {
		this.list = (T[]) new Object[DEFAULT_SIZE]; // Hack
		size = 0;
	}
	public RList(int init_size) {
		this.list = (T[]) new Object[init_size]; // Hack
		size = 0;
	}
	public RList(RList<T> r) {
		this.list = r.list;
		size = r.size;
	}
	public void recreateArray(int size) {
		internalSize = size;
		T[] temp = (T[]) new Object[size]; // Hack
		for(int i = 0; i < this.list.length; i ++) {
			temp[i] = this.list[i];
		}
		this.list = temp;
		
	}
	public void add(T item) {
		this.size ++;
		if(this.size > this.list.length) {
			System.out.println("Extending Array");
			this.recreateArray(internalSize * multiplier);
		}
	}
	public T get(int i) throws ArrayIndexOutOfBoundsException{
		if(i < size) {
			return this.list[i];
		}else {
			throw new ArrayIndexOutOfBoundsException(i+" is out of bounds sry. ");
		}
	}
	// Release must be private
	public void printStats() {
		System.out.println("Internal Size: "+internalSize);
	}
	public void insert(int index, T item) {
		
	}
	public void shift(int start, int end, int newIndex) {
		if(end + newIndex > internalSize) {
			this.recreateArray(internalSize * multiplier);
		}
		
		
		assert start < end;
		T[] newArr = this.list.clone();
		for(int i = start; i < end; i++) {
			
		}
	}
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		RList<Integer> l = new RList<Integer>();
		for(int i = 0; i < 99999; i ++) {
			l.add(i);
			
		}
		long t2 = System.currentTimeMillis();
		System.out.println(l.size + " RList took "+(t2-t1)+"ms ");
		l.printStats();
		t1 = System.currentTimeMillis();
		List<Integer> arraylist = new ArrayList<Integer>();
		for(int i = 0; i < 99999; i ++) {
			arraylist.add(i);
		}
		t2 = System.currentTimeMillis();
		System.out.println("ArrayList took "+(t2-t1)+"ms \n\n\n");
		//System.out.println(l.list.length);
		System.out.println("Performing get benchmark");
		t1 = System.currentTimeMillis();
		for(int i = 0; i < 99999; i++) {
			l.get(i);
		}
		t2 = System.currentTimeMillis();
		System.out.println("RList took "+(t2-t1)+"ms ");
		t1 = System.currentTimeMillis();
		for(int i = 0; i < 99999; i++) {
			arraylist.get(i);
		}
		t2 = System.currentTimeMillis();
		System.out.println("ArrayList took "+(t2-t1)+"ms ");
	}
	

}
