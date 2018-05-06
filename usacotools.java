import java.util.*;
import java.io.*;
public abstract class usacotools {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static int ERRORS=0;
	public static ArrayList<Exception> console=new ArrayList<Exception>();
	public static String error="Error";
	public static int debugcode=-1;
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
	public static void report(Exception e) {
		console.add(e);
		ERRORS++;
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
	public static String[] toArrays(ArrayList<String> arr) {
		String[] stuff=new String[arr.size()];
		for(int i=0;i<arr.size();i++) {
			stuff[i]=arr.get(i);
		}
		return stuff;
	}
	public static void exit() {
		System.exit(1);
	}
	public static void exit(int code) {
		System.exit(code);
	}
	public static long benchmark() {
		return System.currentTimeMillis();
	
	}
	public static long benchmark2() {
		return System.nanoTime();
	}
	public static void clear(){
	    //Clears Screen in java
	    try {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	    } catch (Exception e) {report(e);}
	}
	public static void console() {
		System.out.println("Total Errors: "+ERRORS);
		for(Exception a:console) {
			if(ESTACK) {
			print(a.getStackTrace().toString());
			
			}
			if(EMSG){print(a.toString());print(a.getMessage());print(a.getLocalizedMessage());}
			
		}
	}
    public static void run(String exe){
    	try{Process process = Runtime.getRuntime().exec(exe);}catch(Exception e) {
    		report(e);
    	}
    }
    public static boolean  ESTACK=true;
    public static boolean  EMSG=true;
    
	public static void main(String[] args) throws Exception{
		System.out.println("Running demo");
		Scanner sc=getsysscan();
		print("Welcome to the demo\nYou have many choices \n1} Run help \n2} Check for a update \n3}Run demo to see features");
		print(">","");
		int val;
		try {
		  val=sc.nextInt();
		}catch(Exception e) {
			print("Oops that did not go well please rerun and choose a INTEGER");
			val=-1;
			report(e);
			print("How about we test erro reporting");
			console();
		}
		if(1==val) {
			
		}
	}

}
