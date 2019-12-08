
import java.io.*;
import java.util.*;
public class convention {
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
		if(C == 1) {
			endProgram(N);
		}
		arrivTime.sort(null);
		List<PriorityElem> options = new ArrayList<>();
		int required = 0;
		for(int i = 0; i < N-C; i ++) {
			//System.out.println("Pos: "+(i+C)+" , "+i);
			//System.out.println("Dif: "+arrivTime.get(i+C)+" , "+arrivTime.get(i));
			int diff = arrivTime.get(i+C) - arrivTime.get(i);
			//System.out.println(diff);
			options.add(new PriorityElem(i,diff));
			// Pick diffs
		}
		//Collections.reverse(arrivTime);
		//System.out.println(arrivTime);
		options.sort(null);
		for(PriorityElem pe: options) {
			//System.out.println(pe.item + " "+pe.priority);
		}
		int answer = 0;
		while(true) {
			// Pick Optimally?
			if(required > N - (answer*2)) {
				break;
			}
			PriorityElem p = options.remove(0);
			answer += 1;
			required += C-2;
		}
		System.out.println("");
		endProgram(answer);
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