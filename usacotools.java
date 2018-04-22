import java.util.*;
import java.io.*;
public abstract class usacotools {
	public static int ERROR=1;
	public static String error="Error";
	public static int[][] morph(int[][] map,int a,int b){
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				if(map[i][j]==a) {
					map[i][j]=b;
				}
			}
		}
		return map;
	}
	public static boolean isrect(int[][] map,int x,int y) {
		int cachedsize=-1;
		int cachey=-1;
		for(int i=x;i<map.length;i++) {
			if(x>cachedsize) {
				return false;
			}
			for(int j=y;j<map.length;j++) {
				if(map[x][y]==0) {
					cachey=y;
					cachedsize=x;
				}
				if(y>cachey) {
					return false;
				}
			}
		}
		return true;
	}
	public static ArrayList<Integer> touching(int[][] map,int x,int y){
		ArrayList<Integer> out=new ArrayList<Integer>();
		try {
			out.add(map[x-1][y]);
		}catch(Exception e) {
			
		}
		try {
			out.add(map[x+1][y]);
		}catch(Exception e) {
			
		}
		try {
			out.add(map[x][y-1]);
		}catch(Exception e) {
			
		}
		try {
			out.add(map[x][y+1]);
		}catch(Exception e) {
			
		}
		return out;
		
	}
	public static String repeat(int count, String with) {
	    return new String(new char[count]).replace("\0", with);
	}
	public static String changen(int position, char ch, String str){
	    char[] charArray = str.toCharArray();
	    charArray[position] = ch;
	    return new String(charArray);
	}
	public static BufferedReader mreader(String filen) throws IOException {
		return new BufferedReader(new FileReader(filen));
	}
	public static PrintWriter mwriter(String filen) throws IOException {
		return new PrintWriter(new BufferedWriter(new FileWriter(filen)));
	}
	public static Scanner getsysscan() {
		return new Scanner(System.in);
	}
	public static int binarySearch(int arr[], int l, int r, int x)
    {
		/*
		 * Binary Search
		 * 
		 */
        if (r>=l)
        {
            int mid = l + (r - l)/2;
 
            
            if (arr[mid] == x)
               return mid;
 
            if (arr[mid] > x)
               return binarySearch(arr, l, mid-1, x);
 
            return binarySearch(arr, mid+1, r, x);
        }
 
       
        return -1;
    }
	public static int ebs(int arr[], int l, int r, int x) {
		Arrays.sort(arr);
		return binarySearch(arr, l,  r, x);
	}
	public static int lsearch(int[] a,int b) {
		for(int i=0;i<a.length;i++) {
			if(a[i]==b) {
				return i;
			}
		}
		return -1;
	}
	public static void print(String out) {
		System.out.print(out+"\n");
	}
	public static void printf(String out) {
		System.out.print(out+"\n");
	}
	public static void print(String out,String end) {
		System.out.print(out+end);
	}
	public static void print(String out,boolean flush) {
		System.out.print(out+"\n");
		if(flush) {
			System.out.flush();
		}
	}
	public static int[] toArray(ArrayList<Integer> arr) {
		int[] stuff=new int[arr.size()];
		for(int i=0;i<arr.size();i++) {
			stuff[i]=arr.get(i);
		}
		return stuff;
		
	}
	public static long[] toArrayl(ArrayList<Long> arr) {
		long[] stuff=new long[arr.size()];
		for(int i=0;i<arr.size();i++) {
			stuff[i]=arr.get(i);
		}
		return stuff;
		
	}
	public static String[] toArrays(ArrayList<String> arr) {
		String[] stuff=new String[arr.size()];
		for(int i=0;i<arr.size();i++) {
			stuff[i]=arr.get(i);
		}
		return stuff;
	}
	public static Set<String> sclones(Set<String> k) {
    	return (new HashSet<String>(k));
    }
	public static Set<Integer> sclone(Set<Integer> k) {
    
		return (new HashSet<Integer>(k));
    }
	public static Set<Long> sclonel(Set<Long> k) {
    	return (new HashSet<Long>(k));
    }
	public static void main(String[] args) throws Exception{
		System.out.println("Running demo");
		Scanner sc=getsysscan();
		print("Welcome to the demo\nYou have many choices \n 1} Run help \n2} Check for a update \n3}Run demo to see features");
		print(">","");
		try {
		  int val=sc.nextInt();
		}catch(Exception e) {
			print("Oops that did not go well please rerun and choose a INTEGER");
			
		}
	}

}
