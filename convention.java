
import java.io.*;
import java.util.*;
public class convention {
	public static boolean check(int test,int M, int C, List<Integer> buses) {
		int busStart=buses.get(0);
		int busCount = 1;
		int cowCount = 0;
		for(int i = 0; i < buses.size(); i ++) {
			if(busCount > M) {
				return false;
			}
			int time = buses.get(i);
			if(time - busStart > test || cowCount == C) {
				busCount ++;
				busStart = time;
				cowCount = 0;
			}
			cowCount++;
		}
		return true;
	}
	public static void endProgram(int answer) throws IOException{
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
		pw.println(answer);
		pw.close();
		System.exit(0);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("convention1.in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N,M,C;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());
		f.close();
		System.out.println(N+" "+M+" "+C);
		List<Integer> arrivTime = new ArrayList<>();
		for(int i = 0; i < N; i ++) {
			arrivTime.add(Integer.parseInt(st.nextToken()));
		}
		arrivTime.sort(null);
		//         123456789
		int max = 1000000000;
		int min = 0;
		while(true) {
			int mid = (int) Math.floor((min + max)/2);
			if(check(mid,M,C,arrivTime)) {
				max = mid;
			}else {
				min = mid;
			}
			System.out.println(min+" "+mid+" "+max);
		}
	}

}

class Cow implements Comparator<Cow>{
	int id;
	int aTime;
	public Cow(int id, int aTime) {
		this.id = id;
		this.aTime = aTime;
	}
	@Override
	public int compare(Cow arg0, Cow arg1) {
		// TODO Auto-generated method stub
		return Integer.compare(arg0.aTime, arg1.aTime);
	}
}
class PriorityElem implements Comparator<PriorityElem>, Comparable<PriorityElem>{
	public int multiplier = 1;
	public int priority;
	public int item;
	public PriorityElem(int item, int priority) {
		this.item = item;
		this.priority = priority;
	}
	@Override
	public int compare(PriorityElem arg0, PriorityElem arg1) {
		// TODO Auto-generated method stub
		return Integer.compare(arg0.priority, arg1.priority);
	}
	@Override
	public int compareTo(PriorityElem arg0) {
		
		return this.compare(this, arg0);
	}
}