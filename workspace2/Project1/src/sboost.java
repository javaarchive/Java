import java.io.*;
import java.util.*;
public class sboost {
	public int result;
	public static int[] sort(int[] array) {
		
		Arrays.sort(array);
		
		return array;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader f=new BufferedReader(new FileReader("sboost.in"));
		StringTokenizer st=new StringTokenizer(f.readLine());
		int F=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		
		
		f.close();
	}
}
