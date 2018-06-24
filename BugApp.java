/*
 * Notes
 * 
 * 
 * 
 */
import java.io.*;
import java.util.*;
public class BugApp {
	public static PrintWriter debug;
	public static HashMap<Integer,List> db=new HashMap<Integer,List>();
	public static ArrayList<int[]> resolver=new ArrayList<int[]>();
	public static int info;
	public static void setup() {
		try {
			debug=new PrintWriter(new BufferedWriter(new FileWriter("programdebug.info")));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("WARNING:Log file cannot be initliazed, redirecting to stdout! This may be a restrcited system!");
			debug=new PrintWriter(System.out);
			
		}
		debug.println("Setup completed");
		info=0;
		db.put(0, new ArrayList<Integer>());
	}
	public static void session() {
		int[] resolved;
		debug.println("Session started");
		System.out.println("Debug 1.0 Session\nPress enter to stop\nWarning timing this program will be messed up!");
		String text=">";
		Scanner sc=new Scanner(System.in);
		while(!(text.equals(""))) {
			System.out.print(">");
			text=sc.nextLine();
			try {
				resolved=resolver.get(Integer.parseInt(text));
				show(db.get(resolved[0]).get(resolved[1]));
				
			}catch(Exception e) {
				System.out.println("Failed to find "+text);
			}
			
		}
	}
	public static void show(int x) {
		System.out.println(x);
	}
	public static int add(int x) {
		db.get("int").add(x);
		info++;
		return info-1;
	}
	
	public static void main(String[] args) {
		setup();
		String x="test";
		Var a=new Var("Testing");
		add(a,x);
		session();
		a.set("sync test");
		Var a2=new Var(new ArrayList<Integer>());
		add(a2,"arr");
		session();
	}

}