package Tools;

public class TupleModificationNotAllowedException extends Exception {
	public TupleModificationNotAllowedException(String s) 
	{ 
        // Call constructor of parent Exception 
        super(s); 
    } 
	public TupleModificationNotAllowedException() 
    { 
        // Call constructor of parent Exception 
        super(); 
    } 
}
