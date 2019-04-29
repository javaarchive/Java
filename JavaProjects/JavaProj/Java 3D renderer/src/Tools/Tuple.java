package Tools;

import java.util.*;

public class Tuple{
	public List l;
	public Tuple(List list) {
		this.l=list;
	}
	public Integer remove(int i) throws TupleModificationNotAllowedException{
		throw new TupleModificationNotAllowedException("THIS IS A TUPLE");
	}
	public Integer add(int i) throws TupleModificationNotAllowedException{
		throw new TupleModificationNotAllowedException("THIS IS A TUPLE");
	}
	public static void main(String[] args)throws Exception {
		Tuple t = new Tuple(new ArrayList<Integer>());
		t.add(1);
	}
	
}
