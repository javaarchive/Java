import java.io.*;
import java.util.*;
class Var {
    private Object object;
    public Var() {
    	this.object=null;
    }
    public Var(Object o) {
    	this.object=o;
    }
    public void set(Object object) { this.object = object; }
    public Object get() { return object; }
}
public class debuggableapp {
	public static PrintWriter debug;
	public static HashMap<String,Var> db=new HashMap<String,Var>();
	public static void setup() {
		try {
			debug=new PrintWriter(new BufferedWriter(new FileWriter("programdebug.info")));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("WARNING:Log file cannot be initliazed, redirecting to stdout! This may be a restrcited system!");
			debug=new PrintWriter(System.out);
			
		}
		debug.println("Setup completed");
	}
	public static void session() {
		debug.println("Session started");
		System.out.println("Debug 1.0 Session\nPress enter to stop\nWarning timing this program will be messed up!");
		String text=">";
		Scanner sc=new Scanner(System.in);
		while(!(text.equals(""))) {
			System.out.print(">");
			text=sc.nextLine();
			if(db.containsKey(text)) {
				show(db.get(text));
			}
		}
	}
	public static void show(Var x) {
		debug.println(x.getClass());
		if(x.getClass().getName().contains((CharSequence) "List")) {
			System.out.println("WARNING this is a list");
			debug.println("WARNING this is a list");
		}
		System.out.println(x.get());
	}
	public static void add(Var x,String friendlyname) {
		db.put(friendlyname, x);	
	}
	public static void set(Var x,String friendlyname) {
		db.put(friendlyname, x);
		
		
		
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
