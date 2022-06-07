import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		
		
		// Partie 1: A completer : Création du graphe
		Node nodeA = new Node(0, "A");
		Node nodeB = new Node(1, "B");
		Node nodeC = new Node(2, "C");
		Node nodeD = new Node(3, "D"); 
		Node nodeE = new Node(4, "E");
		Node nodeF = new Node(5, "F");
		Node nodeG = new Node(6, "G");
		 
		Edge edgeAB = new Edge(nodeA, nodeB, 2);
		Edge edgeBA = new Edge(nodeB, nodeA, 2);
		
		Edge edgeAC = new Edge(nodeA, nodeC, 1);
		Edge edgeCA = new Edge(nodeC, nodeA, 1);
		
		Edge edgeBE = new Edge(nodeB, nodeE, 3);
		Edge edgeEB = new Edge(nodeE, nodeB, 3);
		
		Edge edgeBD = new Edge(nodeB, nodeD, 1);
		Edge edgeDB = new Edge(nodeD, nodeB, 1);
		
		Edge edgeBC = new Edge(nodeB, nodeC, 2);
		Edge edgeCB = new Edge(nodeC, nodeB, 2);
		
		Edge edgeCE = new Edge(nodeC, nodeE, 3);
		Edge edgeEC = new Edge(nodeE, nodeC, 3);
		
		Edge edgeEF = new Edge(nodeE, nodeF, 1);
		Edge edgeFE = new Edge(nodeF, nodeE, 1);
		
		Edge edgeCF = new Edge(nodeC, nodeF, 5);
		Edge edgeFC = new Edge(nodeF, nodeC, 5);
		
		Edge edgeCD = new Edge(nodeC, nodeD, 4);
		Edge edgeDC = new Edge(nodeD, nodeC, 4);
		
		Edge edgeDF = new Edge(nodeD, nodeF, 6);
		Edge edgeFD = new Edge(nodeF, nodeD, 6);
		
		Edge edgeDG = new Edge(nodeD, nodeG, 5);
		Edge edgeGD = new Edge(nodeG, nodeD, 5);
		
		Edge edgeFG = new Edge(nodeF, nodeG, 2);
		Edge edgeGF = new Edge(nodeG, nodeF, 2);
		
		//setNodes and Edges in graph;
		List<Node> nodes = Arrays.asList(nodeA,nodeB,nodeC,nodeD,nodeE,nodeF,nodeG);
		List<Edge> edges = Arrays.asList(edgeAB, edgeBA,edgeAC,edgeCA,edgeBE,edgeEB,edgeBD,
										 edgeDB, edgeBC,edgeCB,edgeCE, edgeEC,edgeEF,edgeFE,
										 edgeCF, edgeFC,edgeCD, edgeDC, edgeDF, edgeFD, edgeDG, 
										 edgeGD, edgeFG, edgeGF);
		
		g.setNodes(nodes);
		g.setEdges(edges);
		
		// Partie 2: A completer : Implémentation de l’algorithme Dijkstra
		
		Dijkstra d = new Dijkstra(g);
		
		d.findPath(nodeA, nodeG);
		
		d.afficherTable();

		// Partie 3 : Afficher le chemin le plus court
		System.out.println(d.afficherCourtChemin(nodeA, nodeG));
		g.getEdgesGoingFrom(nodeA);
	
	}
}
