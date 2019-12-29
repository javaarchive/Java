import java.io.*;
import java.util.*;
public class meetings {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader f=  new BufferedReader(new FileReader("meetings.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("meetings.in")));
		int N, L;
		StringTokenizer st = new StringTokenizer(f.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		List<Cow> c = new ArrayList<>();
		for(int i  = 0 ; i <  N ; i++) {
			int w = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			c.add(new Cow(x,d,w));
		}
		// Simulate
		while(true) {
			break; // Temporary to prevent infinite loop
		}
		pw.close();
		f.close();
	}

}
class Cow{
	int pos;
	int velocity;
	int weight;
	public Cow(int pos, int v, int w) {
		this.weight = w;
		this.velocity = v;
		this.pos = pos;
	}
}