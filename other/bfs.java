import java.util.*;
public class bfs implements VisitListener{
	public void onVisit(node n) {
		// Do nothing
		System.out.println(n);
	}
	public Queue<node> q = new LinkedList<node>();
	public ArrayList<node> vn = new ArrayList<node>();
	public ArrayList<node> search(node startNode,VisitListener search) {
		this.q.add(startNode);
		this.vn.add(startNode);
		node cur;
		while(!(q.isEmpty())) {
			cur = this.q.poll();
			if(cur.isvisited()) {
				continue;
			}
			cur.visit();
			search.onVisit(cur);
			for(node sub:cur.connectedNodes) {
				q.add(sub);
				vn.add(sub);
			}
		}
		return vn;
	}
	public ArrayList<node> search(node startNode) {
	return this.search(startNode, this);
	}
	public static void main(String[] args) {
		node a,b,c,d,e,f,g;
		a = (new node()).setid(1);
		b = (new node()).setid(2);
		c = (new node()).setid(3);
		a.linkNode(b);
		a.linkNode(c);
		d = (new node()).setid(4);
		e = (new node()).setid(5);
		f = (new node()).setid(6);
		g = (new node()).setid(7);
		b.linkNode(d);
		b.linkNode(e);
		c.linkNode(f);
		c.linkNode(g);
		(new bfs()).search(a);
	}

}
