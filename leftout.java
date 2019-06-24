import java.io.*;
import java.util.*;
public class leftout {
	public static boolean[][] photo;
	public static void printAsInt(boolean[][] photo) {
		/*
		for (int i = 0; i < photo.length; i++) {
			boolean[] sub = photo[i];
			for (int j = 0; j < sub.length; j++) {
				boolean state = sub[j];
				System.out.print(state ? 0:1);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
		*/
	}
	public static int sumArray() {
		int total = 0;
		for (int i = 0; i < photo.length; i++) {
			boolean[] row = photo[i];
			for (int j = 0; j < row.length; j++) {
				boolean k = row[j];
				if(!k) {
					total++;
				}
			}
		}
		return total;
	}
	public static int sumArray(int x1, int y1,int x2,int y2, boolean state) {
		int total = 0;
		for (int i = x1; i <= x2; i++) {
			boolean[] row = photo[i];
			for (int j = y1; j <= y2; j++) {
				boolean k = row[j];
				if(k == state) {
					total++;
				}
			}
		}
		return total;
	}
	public static boolean checkForTrue() {
		//int total = 0;
		for (int i = 0; i < photo.length; i++) {
			boolean[] row = photo[i];
			for (int j = 0; j < row.length; j++) {
				boolean k = row[j];
				if(!k) {
					return true;
				}
			}
		}
		return false;
	}
	public static boolean checkForTrue(int x,int y) {
		//int total = 0;
		for (int i = 1; i <= x; i++) {
			boolean[] row = photo[i];
			for (int j = 1; j <= y; j++) {
				boolean k = row[j];
				if(k) {
					return true;
				}
			}
		}
		return false;
	}
	public static boolean checkForFalse(int x,int y) {
		//int total = 0;
		for (int i = 1; i <= x; i++) {
			boolean[] row = photo[i];
			for (int j = 1; j <= y; j++) {
				boolean k = row[j];
				if(!k) {
					return true;
				}
			}
		}
		return false;
	}
	public static void flipRow(int row) {
		for(int i = 0; i < photo[row].length; i ++) {
			photo[row][i] = !(photo[row][i]);
		}
	}
	public static void flipCol(int col) {
		for(int i = 0; i < photo.length; i ++) {
			photo[i][col] = !(photo[i][col]);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("leftout.in"));
		final int N = Integer.parseInt(f.readLine());
		photo = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			String row = f.readLine();
			for(int j = 0; j < N; j ++) {
				char c = row.charAt(j);
				if(c == 'L') {
					photo[i][j] = true;
				}else if(c == 'R') {
					photo[i][j] = false;
				}
			}
		}
		printAsInt(photo);
		/*
		// Used to be      N
		for(int i = 0; i < N; i ++) {
			if(!photo[i][0]) {
				flipRow(i);
			}
		}
		printAsInt(photo);
		for(int i = 0; i < N; i ++) {
			if(!photo[0][i]) {
				flipCol(i);
			}
		}*/
		for (int i=1; i<N; i++) {
		    photo[i][0] = photo[i][0] ^ photo[0][0];
		    for (int j=1; j<N; j++) photo[i][j] = photo[i][j] ^ photo[0][j] ^ photo[i][0];
		  }
		printAsInt(photo);
		f.close();
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("leftout.out")));
		int sa = sumArray(0,0,N-1,N-1,true);
		// Old condition sa == 0 || sa == N*N -1
		if(false) {
			//System.out.println("Stop! Sum of whole is ");
			pw.println("-1");
		}else {
			/*
			//boolean not_found = true;
			
			for(int i = 1; i < N; i ++) {
				for(int j = 1; j < N; j ++) {
					//System.out.println(checkForTrue(i,j));
					if(checkForTrue(i,j)) {
						pw.println(i+" "+j);
						pw.close();
						System.exit(0);
						//not_found = false;
					}
				}
			}for(int i = 1; i < N; i ++) {
				for(int j = 1; j < N; j ++) {
					//System.out.println(checkForTrue(i,j));
					if(checkForFalse(i,j)) {
						pw.println(i+" "+j);
						pw.close();
						System.exit(0);
						//not_found = false;
					}
				}
			}
			*/
			/*
			System.out.println("====Launching Debug====");
			for(int i = 1; i < N ; i ++) {
				for(int j = 1; j < N; j ++) {
					System.out.println("--------Debug--------");
					System.out.println();
					System.out.println("True: ");
					System.out.println(i+" "+j+" SUM: "+sumArray(1, 1, i, j, true));
					System.out.println("False: ");
					System.out.println(i+" "+j+" SUM: "+sumArray(1, 1, i, j, false));
				}
			}
			*/
			if (sumArray(1,1,N-1,N-1,false) == 0) {
				pw.println("1 1"); 
				pw.close();
				System.exit(0); 
			}
			  if (sumArray(1,1,N-1,N-1,true) == N-1) {
			    for (int j=1; j<N; j++) {
			    	if (sumArray(1,j,N-1,j,true)==N-1) {
			    		pw.println("1 " + (j+1));
			    		pw.close();
			    		System.exit(0); 
			    	}
			    }
			    for (int i=1; i<N; i++) {
			    	if (sumArray(i,1,i,N-1,true)==N-1) {
			    		pw.println( (i+1) + " 1");
			    		pw.close();
			    		System.exit(0); 
			    	}
			    } 
			    System.out.println("-1 1st");
			    pw.println("-1\n");
			    pw.close();
			    System.exit(0);
			  }
			  if (sumArray(1,1,N-1,N-1,true)!=1) {
				  System.out.println("-1 2nd");
				  pw.println("-1");
				  pw.close();
				  System.exit(0); 
			  } 
			  for (int i=1; i<N; i++)
			    for (int j=1; j<N; j++)
			      if (photo[i][j]==true) { pw.println((i+1) + " " + (j+1)); }
			  
		}
		pw.close();
	}

}
