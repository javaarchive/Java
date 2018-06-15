/*
TASK:transform
ID:johnath6
LANG:JAVA
PROG:transform
 */
import java.io.*;
import java.util.*;
public class transform {
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
	public static int[][] reverseh(int[][] a) {
    	/*
    	 * Reverse 2D array horizontal
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
    public static int[][] reversev(int[][] a) {
    	/*
    	 * Reverse 2D array vertically
    	 */
    	int[][] newa=new int[a.length][a[0].length]; 
    	for(int i=0;i<a.length;i++) {
    		newa[i]=reverse(a[i]);
    	}
    	return newa;
    }
    public static void printarray2D(int[][] a) {
    	for(int[] s:a) {
    		for(int k:s) {
    			System.out.print(k+" ");
    		}
    		System.out.println();
    	}
    }
    public static int[][] rotate90(int[][] map) {
    	/*
    	 * Rotate 2D array 
    	 * 90 degree clockwise 
    	 */
    	int N=map.length;
    	int[][] n=new int[N][N];
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			n[j][N-1-i]=map[i][j];
    		}
    	}
    	return n;
    }
    public static int classify(char x,char off,char on) {
    	/*
    	 * Method to classify X is off value or on value
    	 * Returns -1 if neither
    	 * 
    	 */
    	
    	if (x==off){
    		return 2;
    	}else if(x==on) {
    		return 5;
    	}else {
    		return -1;
    	}
    }
    public static void print(String out) {
		System.out.print(out+"\n");
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
    		if(!(smartequals(a[i],b[i]))) {
    			return false;
    		}
    	}
    	return true;
    }
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
        BufferedReader f=new BufferedReader(new FileReader("transform.in"));
        PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        int answer=7;
        int N=Integer.parseInt(f.readLine());
        String cline;
        int[][] a=new int[N][N];int[][] b=new int[N][N];
        for(int i=0;i<N;i++) {
        	cline=f.readLine();
        	for(int j=0;j<N;j++) {
        		a[i][j]=classify(cline.charAt(j),'-','@');
        	}
        }
        for(int i=0;i<N;i++) {
        	cline=f.readLine();
        	for(int j=0;j<N;j++) {
        		b[i][j]=classify(cline.charAt(j),'-','@');
        	}
        }
        if(smartequals2D(a,rotate90(b))) {
        	print("270 rotation         ");
        	answer=1;
        }else if(smartequals2D(a,reverseh(b))) {
        	print("180 rotate");
        	answer=2;
        }else if(smartequals2D(a,reversev(b))) {
        	print("H reflect");
            answer=4;
        }else if(smartequals2D(a,rotate90(rotate90(rotate90(b))))) {
        	print("90 rotate");
        	answer=3;
        }else if(smartequals2D(a,b)){
        	print("SAME");
        	answer=6;
        }else {
            print("testing combination");
            a=reversev(a);
            if(smartequals2D(a,b)){
            	print("SAME");
            	answer=5;
            }else if(smartequals2D(a,rotate90(b))) {
            	print("90 rotation");
            	answer=5;
            }else if(smartequals2D(a,reverseh(b))) {
            	print("180 rotate");
            	answer=5;
            }else if(smartequals2D(a,rotate90(rotate90(rotate90(b))))) {
            	print("270 rotate");
                answer=5;	
            }else {
            	answer=7;
            }
        }
        printarray2D(b);printarray2D(a);
        pw.println(answer);
        pw.close();
	}
}