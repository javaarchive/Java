import java.io.*;
import java.util.*;
import java.util.*;
/*
 * 
 * 
 * Improvement for cowroute
 */
public class cowroute {
	
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		BufferedReader f= new BufferedReader(new FileReader("6.in"));
		st=new StringTokenizer(f.readLine());
		
		int[] route= {0,0,0};
		ArrayList<int[]> aroutes=new ArrayList<int[]>();
		ArrayList<int[]> broutes=new ArrayList<int[]>();
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		/*
		 * A routes and B routes item structure
		 * First item-price
		 * 1-Index
		 * 2-Which route
		 */
		 
		 boolean Before;
		 boolean after;
		 @SuppressWarnings("unchecked")
		 ArrayList<Integer>[] data=new ArrayList[N];
		 int price;
		 int M,id;
		 for(int i=0;i<N;i++) {
			 data[i]=new ArrayList<Integer>();
			 st=new StringTokenizer(f.readLine());
			 price=Integer.parseInt(st.nextToken());
			 M=Integer.parseInt(st.nextToken());
			 st=new StringTokenizer(f.readLine());
			 for(int j=0;j<M;j++) {
				 id=Integer.parseInt(st.nextToken());
				 if(id==A) {
					 route[0]=j;
					 route[1]=i;
					 route[2]=price;
					 aroutes.add(route.clone());
				 }else if(id==B) {
					 route[0]=j;
					 route[1]=i;
					 route[2]=price;
					 broutes.add(route.clone());
				 }
				 data[i].add(id);
			 }
			 data[i].add(0, price);
		 }
		 //System.out.println("Finished first loop Debug status A:"+A+"   B:"+B+"  N:"+N);
		 int low=-1;
		 boolean k=true;
		 int r,x;
		 int price2=0,index,index2,count;
		 ArrayList<Integer> a,b;
		 a=new ArrayList<Integer>();b=new ArrayList<Integer>();
		 //System.out.println("====Entering main loop===");
		 
		 for(int[] stuff:aroutes) {
			 a.clear();
			 
			 price=stuff[2];//Get price
			 index=stuff[0];
			 r=stuff[1];
			 count=0;
			 after=false;
			 for(int i:data[r]) {//For every item in the A route
				 
				 if(i==A) {
					 after=true;
					 continue;
				 }else if(i==B) {// If B is also in the route and we are past "A"
					 if((price)<low||k) {
						 k=false;
						 //System.out.println("New low cost by all in one");
						 System.out.println("Debug Info index:"+index+"- count:"+count);
						 low=price;
					 }
				 
				 }
				 count++;
				 
				 if(after) {a.add(i);}
			 }
			 for(int[] dat:broutes) {
				 
				 b.clear();
				 
				 price2=dat[2];//Get price
				 index2=dat[0];
				 //r2=stuff[1];
				 Before=true;
				 for(int m=0;m<data[r].size();m++) {
					 x=data[r].get(m);
					 if(x==B) {
						 Before=false;
						 continue;
					 }
					 if(Before) {
					 
					 
					 b.add(x);
					 }
				 }
				 a.sort(null);
				 b.sort(null);
				 for(int i=0;i<a.size();i++) {
					 System.out.println("Info I:"+i);
					 count=a.get(i);
					 
					 if(Arrays.binarySearch(b.toArray(),(a.get(i)))>-1) {//Flight overlap
						 if(((price2+price)<low||low==-1)) {
							 System.out.println("Debug for new overlap: The same value is:"+a.get(i)+" The first price is price:"+price+" and price2:"+price2);
							 System.out.println("Debug count:"+count+" index2:"+index2);
							 System.out.println("New low cost by overlap");
							 low=price2+price;
						 }
					 }
				 }
			 }
			 
			 
			 
			 
		 }
		 PrintWriter pw=new PrintWriter(new FileWriter("cowroute.out"));
		 pw.println(low);
		 pw.close();
		 f.close();
		 
		 
	}

}
