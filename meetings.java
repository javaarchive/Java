import java.io.*;
import java.util.*;
public class meetings {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("meetings.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
		int stoppedWeight = 0;
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		//List<Event> eventSeq = new ArrayList<>();
		List<Cow> cows = new ArrayList<>();
		double halfSumWeight = 0;
		int preP=0;
		for(int i =0 ; i < N; i ++) {
			st = new StringTokenizer(f.readLine());
			int w,v,p,d;
			w = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken())*2;
			v = Integer.parseInt(st.nextToken());
			d = 0;
			//System.out.println(v);
			cows.add(new Cow(w,p,v, d));
			halfSumWeight += w;
		}
		halfSumWeight = halfSumWeight/2;
		L = 2*L;
		
		cows.sort(null);
		preP = cows.get(0).P;
		int minDis; 
		minDis = L + 1;
		for(int i =1 ; i < cows.size(); i ++) {
			int d = cows.get(i).P - preP;
			cows.get(i).D = d;
			if(cows.get(i-1).V == 1&& cows.get(i).V==-1)
			{
				if(d<minDis)
				{
					minDis = d;
				}
			}
			preP = cows.get(i).P;
				
		}
		
		
		if(cows.get(0).V == -1)
		{
			int d = cows.get(0).P;
			if(d<minDis)
			{
				minDis = 2*d;
			}
			
		}
		
		if(cows.get(cows.size()-1).V == 1)
		{
			int d = cows.get(cows.size()-1).P;
			if(d<minDis)
			{
				minDis = 2*d;
			}
			
		}		
		//System.out.println(cows);
		//int curTime = 0;
		int meet = 0;
		int elapsetime = minDis/2;
		
		
		while(true) {
			//Event nextEvent = null;
			
			cows.get(0).P = cows.get(0).P + cows.get(0).V*elapsetime;
			int i = 1;
			for(i = 1; i < cows.size(); i ++) {
				int tmpI = cows.get(i).P + cows.get(i).V*elapsetime;
				if (cows.get(i-1).P == tmpI)
				{
					cows.get(i).V = -cows.get(i).V;
					cows.get(i-1).V = -cows.get(i-1).V;
					meet++;
				}
				cows.get(i).P = tmpI;
			}
			int nCow = i-1;
			if(cows.get(0).P == 0) {
				stoppedWeight += cows.get(0).W;
				cows.remove(0);
				nCow--;
			}	
			if(cows.get(nCow).P == L) {
				stoppedWeight += cows.get(nCow).W;
				cows.remove(nCow);
			}	
			
			if(stoppedWeight >= halfSumWeight) {
				break;
			}
			
			preP = cows.get(0).P;
			minDis = L + 1;
			for(i =1 ; i < cows.size(); i ++) {
				int d = cows.get(i).P - preP;
				cows.get(i).D = d;
				if(cows.get(i-1).V == 1&& cows.get(i).V==-1)
				{
					if(d<minDis)
					{
						minDis = d;
					}
				}
				preP = cows.get(i).P;
					
			}
			
			
			if(cows.get(0).V == -1)
			{
				int d = cows.get(0).P;
				if(d<minDis)
				{
					minDis = 2*d;
				}
				
			}
			
			if(cows.get(cows.size()-1).V == 1)
			{
				int d = cows.get(cows.size()-1).P;
				if(d<minDis)
				{
					minDis = 2*d;
				}
				
			}
			elapsetime = minDis/2;
	
		}
		pw.println(meet);
		f.close();
		pw.close();
	}

}
class Cow implements Comparable<Cow>{
	public int W,P,V, D;
	public Cow(int W,int P, int V, int D) {
		this.W = W;
		this.P = P;
		this.V = V;
		this.D = D;
	}
	@Override
	public int compareTo(Cow o) {
		return Integer.compare(this.P, o.P);
	}
	@Override
	public String toString() {
		return "#"+P+" moving at "+V+" with weight"+W;
	}
	
}
class Event implements Comparable<Event>{
	@Override
	public String toString() {
		return "@"+time+" "+cow1+" collides with "+cow2+" at pos "+pos;
	}
	public int time,pos,cow1,cow2;
	public Event(int time, int pos, int cow1, int cow2) {
		this.time = time;
		this.pos = pos;
		this.cow1 = cow1;this.cow2 = cow2;
	}
	@Override
	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.time, o.time);
	}
}
