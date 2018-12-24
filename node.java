import java.util.*;

public class node {
	private int id = -1;
	private static int nextId = 101;
	public void init() {
		this.id = nextId;
		nextId++;
	}
	ArrayList<node> connectedNodes;
	public node() {
		init();
		this.connectedNodes = new ArrayList<node>(0);
	}
	public node(node n) {
		init();
		this.connectedNodes = new ArrayList<node>(1);
		this.connectedNodes.add(n);
	}
	public void connect(node n) {
		this.connectedNodes.add(n);
	}
	public ArrayList<node> getChildNodes(){
		return this.connectedNodes;
	}
	public int graphId;
	public void setId(int id) {
		this.graphId = id;
	}
	public node setid(int id) {
		this.graphId = id;
		return this;
	}
	public int getId() {
		return this.graphId;
	}
	public int getUniqueId() {
		return this.id;
	}
	/* Diff mode settings
	 * 0 - compare by id
	 * 1 - compare by unique id
	 * 2 - Compare by connected nodes
	 */
	public static int diffmode = 0;
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof node) {
		node e = (node) obj;
		if(diffmode == 0) {
			return (this.getId() == e.getId());
		}else if(diffmode == 1) {
			return (this.getUniqueId() == e.getUniqueId());
		}else if(diffmode == 2) {
			return (this.connectedNodes.equals(e.connectedNodes));
		}
		}else {
			return false;
		}
		return false;
	}
	public void linkNode(node n) {
		this.connectedNodes.add(n);
	}
	public node addChild(node n) {
		this.linkNode(n);
		return this;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("node(");
		sb.append("id = ");
		sb.append(this.graphId);
		sb.append(", uniqueId = ");
		sb.append(this.getUniqueId());
		sb.append(", children = ");
		sb.append(this.connectedNodes.toString());
		sb.append(" )");
		return sb.toString();
	}
	private boolean visited;
	public void reset() {
		this.visited = false;
	}
	public void visit() {
		this.visited = true;
	}
	public boolean isvisited() {
		return this.visited;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node.diffmode = 0;
		System.out.println((new node()).addChild(new node()));
	}

}
