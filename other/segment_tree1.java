import java.util.*;
public class segment_tree1 {
	public static  int min(int x, int y) { 
		 	//return Math.min(x, y);
	        return (x < y) ? x : y; 
	    }
	public static final int NO_VALUE = 0;
	public static int div(int a,int b) {
		return (int) Math.floor(a/b);
	}
	public static int calc_half1(int x,int y) {
		return div((y-x) - 1,2);
	}
	public static int calc_half2(int x,int y) {
		return div((y-x),2) + 1;
	}
	public static int getMid(int s, int e) { 
        return s + (e - s) / 2; 
    } 
	public static int getMaxSize(int x) {
		return 2 * (int) Math.pow(2, x) - 1; 
	}
	public static int pow2(int x) {
		return (int) Math.pow(2, x);
	}
	public static int[] st;
	public static int[] segmenttree(int[] arr) {
		st = new int[getMaxSize(arr.length)];
		int n = arr.length;
		recur_st(arr,0,n-1,0);
		return st;
	}
	static int times_recuron = 0;
	public static int recur_st(int[] arr,int a,int b,int c) {
		times_recuron ++;
		if(times_recuron>1000) {
			return 0;
		}
		if(a==b) {
			st[c] = arr[a];
			return arr[a];
		}
		int mid = getMid(a, b); 
        st[c] = recur_st(arr,a, mid, c * 2 + 1) + recur_st(arr, mid + 1, b, c * 2 + 2); 
        return st[c]; 
	}
	 public static int getsum(int a, int b, int c, int d, int e){ 
	        if (c <= a && d >= b) 
	            return st[e]; 
	        if (b < c || a > d) 
	            return 0;
	        int mid = getMid(a, b); 
	        return getsum(a, mid, c, d, 2 * e + 1) + getsum(mid + 1, b, c, d, 2 * e + 2); 
	    } 
	 public static int recursionRMQ(int a, int b, int c, int d, int index){ 
	        if (c <= a && d >= b) 
	            return st[index];  // Lookup when done
	        if (b < c || a > d) 
	            return Integer.MAX_VALUE; // This is my infinite value
	        int mid = getMid(a, b); 
	        return min(recursionRMQ(a, mid, c, d, 2 * index + 1), 
	        		recursionRMQ(mid + 1, b, c, d, 2 * index + 2)); 
	    } 
	 public static int RMQ(int n, int a, int b) 
	    { 
	        if (b > n - 1 || a > b || a < 0 ) { 
	            System.out.println("input not valid"); 
	            return -1; 
	        } 
	  
	        return recursionRMQ(0, n - 1, a, b, 0); 
	    } 
	public static void main(String[] args) {
		System.out.println("Self Test segement tree");
		System.out.println("From 0 to 6: "+calc_half1(0,6));
		//int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		//int[] arr = {1,2,3,4,5,6};
		//int[] arr ={1, 3, 5, 7, 9, 11};
		//System.out.println(1 << 2);
		int[] arr = {0,5,2,5,4,3,1,6,3};
		System.out.println(Arrays.toString(segmenttree(arr)));
		System.out.println("RMQ: "+RMQ(arr.length, 2,7));
	}

}
