import java.util.*;
public class postfix {

	public static void main(String[] args) {
		System.out.println("ENTER THE EQUATION IMMEDIATLEY");
		Scanner sc=new Scanner(System.in);
		String equation=sc.nextLine();
	    Stack<String> op=new Stack<String>();
	    Stack<Integer> nums=new Stack<Integer>();
	    System.out.println("---Evaluating your equation right now---");
	    String current="";
	    String chara;
	    try {
	    for(int i=0;i<equation.length();i++) {
	    	chara=Character.toString(equation.charAt(i));
	    	System.out.println("PROCESSING CHAR "+chara);
	    	if(chara.equals("+")) {
	    		op.push(chara);
	    	}else if(chara.equals("-")) {
	    		op.push(chara);
	    		i++;
	    	}
	    	else if(chara.equals("*")) {
	    		op.push(chara);
	    		i++;
	    	}
	    	else if(chara.equals("/")) {
	    		op.push(chara);
	    		i++;
	    	}else if(chara.equals("%")) {
	    		op.push(chara);
	    		i++;
	    	}else if(chara.equals(" ")){
	    		try{
	    			
	    			nums.push(Integer.parseInt(current));
	    			
	    		}catch(Exception e) {
	    			throw new Exception("INVALID OPERATOR");
	    		}
	    		current="";
	    	}else {//It's a number
	    	    current=current+chara;
	    	}
	    	
	    	
	    	

	    	
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    if(nums.size()!=(op.size()+1)) {
	    	throw new Exception("NOT ENOUGH OPERATORS");
	    }
	    int result,num;
	    String o;
	    result=nums.pop();
	    System.out.println("Almost done calculating");
	    System.out.println(nums.size()+" "+op.size());
	    for(int i=0;i<nums.size();i++) {
	    	num=nums.pop();
	    	o=op.pop();
	    	System.out.println(num);
	    	if(o.equals("*")){
	    		result=result*num;
	    	}else if(o.equals("/")) {
	    		result=result/num;
	    	}else if(o.equals("+")) {
	    		result=result+num;
	    	}else if(o.equals("-")) {
	    		result=result*num;
	    	}else if(o.equals("%")) {
	    		result=result%num;
	    	}
	    }
	    System.out.println("CALC:"+result);
	    }catch(Exception e) {
	    	System.out.println("YOU HAVE JUST VOIDED THE WARRANTY ERROR:"+e.getMessage());
	    }
	    

	}

}
