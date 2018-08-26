import java.io.*;
public class compilestandard extends usacotools {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader f;
		if(args.length==1) {
			if(args[0].equals("eclipse")) {
				f=mreader("src/usacotools.java");
			}else {
				f=mreader("usacotools.java");
			}
			
		}else {
				f=mreader("usacotools.java");
			}
		
		print("build");
		
		String st;
		String full="";
		
		while ((st = f.readLine()) != null) {
		    full=full+st+"\n";
		  }
		String text=full.replace("if(!(lock)) {return null;}", "");
		text=text.replace("public abstract class usacotools","public abstract class utools");
	 	print(text);
	 	PrintWriter pw=mwriter("utools.java");
	 	if(args[0].equals("eclipse")) {
			pw=mwriter("src/utools.java");
		}else {
			
		}
	 	pw.println(text);
	 	pw.close();
	 	
	}
}
