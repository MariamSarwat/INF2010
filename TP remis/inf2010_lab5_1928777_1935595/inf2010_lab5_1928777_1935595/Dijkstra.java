import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Dijkstra {

	private Graph graph;
	private Map<Node, Edge> dijkstraTable[];
	private Stack<Edge> path;

	public Dijkstra (Graph g) {
		this.graph = g;
	}

	@SuppressWarnings("unchecked")
	public void findPath (Node s, Node f) {
		
		dijkstraTable = new HashMap[graph.getNodes().size()];
		path = new Stack<Edge>();
		
		//Create the Djikstra table
		for(int i=0; i < graph.getNodes().size(); i++) {
			dijkstraTable[i] = new HashMap<Node, Edge>();
		}
		
		//Create the strarting Edge
		Edge edge = new Edge(s,s,0);
		
		dijkstraTable[0].put(edge.getDestination(),edge);
		
		Node nextNode= s;
		ArrayList<Node> knownNodes= new ArrayList<Node>();
		
		knownNodes.add(nextNode);
		path.push(edge);
		
		int i =1;
		//Condition to keep searching for the shortest path till we reach the destination node
		while (nextNode != f){
			
			dijkstraTable[i] = new HashMap<Node, Edge>(dijkstraTable[i-1]);
			dijkstraTable[i].remove(nextNode);
			//Able to get all the edges from the node we are currently at
			ArrayList<Edge> adjacent = new ArrayList<Edge>(graph.getEdgesGoingFrom(nextNode));
			for(Edge e : adjacent){
				//Allows to input in the dijkstra table the distance to the destination node going from the "nextNode" variable
				Edge adjacentEdge = new Edge(e.getSource(), e.getDestination(), e.getDistance() + (dijkstraTable[i-1].get(nextNode)).getDistance());
				if((!(knownNodes.contains(adjacentEdge.getDestination()))) && 
						(!(dijkstraTable[i].containsKey(adjacentEdge.getDestination())) || !(adjacentEdge.getDistance() > dijkstraTable[i].get(adjacentEdge.getDestination()).getDistance()))){
					dijkstraTable[i].put(adjacentEdge.getDestination(), adjacentEdge);
				}	
			}
			//The next node to continue to find the shortest path will be the one with the smallest distance is the table
			nextNode = getMinimum(dijkstraTable[i]);
			
			path.push(dijkstraTable[i].get(nextNode));
			knownNodes.add(nextNode);
			i++;
		}
	}

	private Node getMinimum(Map<Node, Edge> map) {
		Edge min = null;
		for (Node Key : map.keySet()) {
			if ( min == null || map.get(Key).getDistance() < min.getDistance()) {
				min = map.get(Key); 
			}
		}
		return min.getDestination();
	}

	@SuppressWarnings("unused")
	private Edge getMinimum (Edge e1, Edge e2) {
		if (e1.getDistance() < e2.getDistance())
			return e1;
		else
			return e2;
	}
	
	public String afficherCourtChemin (Node source, Node destination) {
		
		StringBuilder courtChemin = new StringBuilder();
		
		this.findPath(source,destination);
		Edge nextEdge = path.pop(); //getting the edge on top of the stack which corresponds to the shortest distance 
		
		System.out.println("");
		System.out.print("\nLa longueur du plus court chemin est : ");
		System.out.println(nextEdge.getDistance());
		
		courtChemin.append(nextEdge.getDestination().getName() + " >- ");
		
		while (!path.empty()){
			if (path.peek().getDestination() == nextEdge.getSource()){
				if(nextEdge.getSource()!=source)
					courtChemin.append(nextEdge.getSource().getName() + " >- ");
				else
					courtChemin.append(nextEdge.getSource().getName() + " ");
				
				nextEdge = path.pop();
				
			}else
				path.pop(); //no use if the destination node is not the source of the nextEdge variable
		}
		
		return "Le chemin le plus court est : " + courtChemin.reverse().toString();
	}

	public void afficherTable () {
		ArrayList<Node> nodes = new ArrayList<Node>(graph.getNodes());
		
		for (int i = 0; i < nodes.size(); i++)
			System.out.print(nodes.get(i).getName() + "\t");

		for (int i = 0; i < dijkstraTable.length; i++){
			System.out.println(" ");
			for(int j = 0; j < nodes.size(); j++){
				if (dijkstraTable[i].containsKey(nodes.get(j)))
					System.out.print(dijkstraTable[i].get(nodes.get(j)).getDistance() + dijkstraTable[i].get(nodes.get(j)).getSource().getName() + "\t");
				else
					System.out.print("- \t");
			}
		}	
	}
}