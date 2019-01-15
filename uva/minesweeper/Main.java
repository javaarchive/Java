import java.io.IOException;
import java.util.Scanner;
class Main {
	int[][] put(int[][] arr,int x,int y){
		try{
			if(arr[x][y]==-1) {
		
			return arr;
		}
		arr[x][y]++;
		return arr;
		}catch(Exception e) {
			return arr;
		}
	}
	int[][] process(int[][] arr,int x,int y){
		arr=put(arr,x,y+1);
		arr=put(arr,x,y-1);
		arr=put(arr,x-1,y);
		arr=put(arr,x+1,y);
		arr=put(arr,x+1,y+1);
		arr=put(arr,x-1,y+1);
		arr=put(arr,x+1,y-1);
		arr=put(arr,x-1,y-1);
		return arr;
		
	}
	int dosort(Character y) {
		if(y.equals('-')) {
			return 0;
		}else {
			return -1;
		}
	}
	void loop(Scanner sc) throws IOException{
		int x=sc.nextInt();int y=sc.nextInt();
		System.out.println(x+" "+y);
		int[][] arr=new int[x][y];
		sc.nextLine();
		String buf;
		for(int i=0;i<x;i++) {
			System.out.println(">");
			buf=sc.nextLine();
			for(int j=0;j<y;j++) {arr[i][j]=dosort(buf.charAt(j));}
			
		}
		
	}
	void start() throws IOException{
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextLine()) {
			System.out.println("Executing");
			loop(sc);
		}
	}
	
	public static void main(String[] args) throws IOException{
		Main main=new Main();
		main.start();
		
		
	}

}
