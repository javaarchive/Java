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
	 	print(full.replace("if(!(lock)) {return null;}", ""));
	}
}
