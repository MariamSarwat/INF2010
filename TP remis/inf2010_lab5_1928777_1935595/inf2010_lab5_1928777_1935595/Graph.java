import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<Node> nodes; // Noeuds
	private List<Edge> edges; // Les arcs
	
	public Graph() {
		this.nodes = new ArrayList<Node>();
		this.edges = new ArrayList<Edge>();
	}
	
	public List<Edge> getEdgesGoingFrom(Node source) {
		
		List<Edge> goingFrom = new ArrayList<Edge>();
		
		for(Edge e: edges) {
			if(e.getSource() == source)
				goingFrom.add(e);		
		}
		return goingFrom;
	}
	
	public List<Edge> getEdgesGoingTo(Node dest) {
		List<Edge> goingTo = new ArrayList<Edge>();
		
		for(Edge e : edges) {
			if(e.getDestination() == dest)
				goingTo.add(e);		
		}
		return goingTo;
	}
	
	// Accesseurs 
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
}
