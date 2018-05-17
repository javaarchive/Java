
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
	public static boolean DEBUG=false;
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
	public static Set<String> sclones(Set<String> k) {
    	return (new HashSet<String>(k));
    }
	public static Set<Integer> sclone(Set<Integer> k) {
    
		return (new HashSet<Integer>(k));
    }
	public static Set<Long> sclonel(Set<Long> k) {
    	return (new HashSet<Long>(k));
    }
	public static boolean smartequals(int[] a,int[] b) {
    	if(a.length!=b.length) {
    		return false;
    	}
    	for(int i=0;i<a.length;i++) {
    		if(a[i]!=b[i]) {
    			return false;
    		}
    	}
    	return true;
    }
    public static boolean smartequals2D(int[][] a,int[][] b) {
    	if(a.length!=b.length) {
    		return false;
    	}
    	for(int i=0;i<a.length;i++) {
    		if(smartequals(a[i],b[i])) {
    			return false;
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
	public static int[][] copy2D(int[][] a){
		int[][] b=new int[a.length][];
		for(int i=0;i<a.length;i++) {
			b[i]=new int[a[i].length];
			for(int j=0;j<a[i].length;j++) {
				b[i][j]=a[i][j];
			}
		}
		return b;
	}
	public static int[] copyarr(int[] a) {
		int[] b=new int[a.length];
		
		for(int i=0;i<a.length;i++) {
			b[i]=a[i];
		}
		return b;
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
    public static int[] reverse(int[] a) {
    	int temp;
    	for(int i = 0; i < a.length / 2; i++)
    	{
    	    temp = a[i];
    	    a[i] = a[a.length - i - 1];
    	    a[a.length - i - 1] = temp;
    	}
    	return a;
    }
    public static int[][] reversev(int[][] a) {
    	/*
    	 * Reverse 2D array
    	 */
		int[] temp;
		for(int i = 0; i < a.length / 2; i++)
		{
		    temp = a[i];
		    a[i] = a[a.length - i - 1];
		    a[a.length - i - 1] = temp;
		}
		return a;
	}
    public static int[][] reverseh(int[][] a) {
    	/*
    	 * Reverse 2D array
    	 */
    	int[][] newa=new int[a.length][a[0].length]; 
    	for(int i=0;i<a.length;i++) {
    		newa[i]=reverse(a[i]);
    	}
    	return newa;
    }
    public static int[][] rotate90cw(int[][] map) {
    	/*
    	 * Rotate 2D array 
    	 * 90 degree clockwise 
    	 */
    	int N=map.length;
    	int[][] n=new int[map[0].length][N];
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			n[j][N-1-i]=map[i][j];
    		}
    	}
    	return n;
    }
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
    public static int classify(char x,char off,char on) {
    	/*
    	 * Method to classify X is off value or on value
    	 * Returns -1 if neither
    	 * 
    	 */
    	if (x==off){
    		return 0;
    	}else if(x==on) {
    		return 1;
    	}else {
    		return -1;
    	}
    	
        }
        public static long slowfib(long num){
    	if(num<=1) {
    		return num;
    	}
    	
    	return slowfib(num-1)+slowfib(num-2);
    }
    public static ArrayList<Long> fibmem=new ArrayList<Long>();
    public static long ffib(long n){
    	if(n<=1) {
    		return n;
    	}
    	
    	if(fibmem.size()>n) {
    		return fibmem.get((int) n-1)+fibmem.get((int) n-2);
    	}else {
    		fibmem.add(ffib(n-1)+ffib(n-2));
    		return fibmem.get((int)  n);
    	}
    }
    public static void print() {
    	System.out.println();
    }
    public static void setupfib() {
        fibmem.add((long) 0);fibmem.add((long)1);fibmem.add((long)1);fibmem.add((long)2);
    }
    public static void show2Darr(int[][] a) {
    	for(int[] b:a) {
    		for(int c:b) {
    			print(c+" ","");
    		}
    		print();
    		
    	}
    }
    public static void showarr(int[] a) {
    	for(int x:a) {print(x+" ");}
    }
	public static void main(String[] args) throws Exception{
		/*
		 * Short demo of stuff
		 * Making an error would also demo error reporting
		 * 
		 * 
		 */
		System.out.println("Running demo");
		Scanner sc=getsysscan();
		print("Welcome to the demo");
		print(">","");
		int val;
		/*
		int[][] testarray= {
				{1,1,2,7,7,1,1,1},
				{1,1,4,0,7,1,2,2},
				{0,3,6,9,1,0,0,0},
				{0,3,0,1,0,0,0,0},
				{0,3,0,0,0,0,0,0},
				{1,1,5,1,3,1,1,1},
				{1,1,1,1,3,1,1,1},
		};
		*/
		int[][] testarray= {
				{1,2,3,1},
				{4,5,6,2},
				{7,8,9,3},
				{10,69,1,4}
				
		};
		print("Roation of 90 degrees\n Before \n ");
		show2Darr(testarray);
		print("After \n");
		show2Darr(rotate90cw(testarray));
		print("BEFORE:");
		int[][] ii= {
				{1,1,2,3},
				{1,0,2,1},
				{1,1,1,1},
				{1,2,3,4}
		};
		show2Darr(ii);
		print("After H reflect:");
		show2Darr(reverseh(ii));
		
		try {
		  val=sc.nextInt();
		}catch(Exception e) {
			print("Oops that did not go well please rerun and choose a INTEGER");
			val=-1;
			report(e);
			print("How about we test error reporting");
			console();
		}
		if(1==val) {
			
		}
	}
}
