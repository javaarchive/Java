/*
TASK:beads 
ID:johnath6
LANG:JAVA
PROG:beads
 */


import java.io.*;

public class beadsold {

	public static void main(String[] args) throws IOException {
		BufferedReader f=new BufferedReader(new FileReader("beads.in"));
		int N=Integer.parseInt(f.readLine());
		String beads=f.readLine();
		boolean loopagain=true;
		String current="";
		String a=Character.toString(beads.charAt(0));
		int max=0;
		int prev=0;
		boolean again=true;
		boolean condtion;
		int debuglevel=0;
		for(int j=0;j<N;j++) {
			a="!";
			for(int i=j;i<N;i++) {
				current=Character.toString(beads.charAt(i));
				System.out.print(i);
				
				condtion=true;
				if(!(current.equals("w")||max==0)&&a.equals("!")) {
					debuglevel=2;
					condtion=current.equals(a)||current.equals("w");
					if(again==false&&i==0) {
						debuglevel=1;
						condtion=condtion||Character.toString(beads.charAt(N-1)).equals("w");
					}
				}else if(i!=0) {
					condtion=condtion||a.equals("w");
					debuglevel=3;
				}else if(a.equals("csdfd")){
					condtion=true;
				}
				System.out.println(" "+condtion+"\t"+debuglevel+"\t"+a);
				if(condtion) {
					max++;
					
					//System.err.println("found");
					//System.out.println(current+"    "+max);
					
					
				}else if(loopagain){
					a=current;
					loopagain=false;
					max++;
					
					
				}else {
					
				
					if(max>prev) {
						prev=max;
						max=0;
					}
					
					loopagain=true;
					a=current;
					System.out.println("NEW");
					System.out.println("RESULT: "+max);
					max=0;
					if(again==false) {
						break;
					}
					
					
					
				}
				if(i==(beads.length()-1)&&again) {
					i=0;
					//System.err.println("Debug: Reloop");
					again=false;
				}
			}
			again=true;
			debuglevel=0;
			
		}
			
		
						
		
	System.out.println(prev);
	f.close();	}}
	
