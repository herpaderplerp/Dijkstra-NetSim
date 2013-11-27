import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class main {

	private List<Vertex> nodes;
	private List<Edge> edges;

	public static void main(String[] args) {


		main main = new main();
		main.conversion();

		System.exit(0);

	}

	public void conversion() {

		nodes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();

		// Scanner sc = new Scanner(args[0]);
		try {
			File file = new File(
					"C:/Users/cJustin/Documents/School/School-2013-2014-Sem7-Fall/NETSIM-NET4001/Project/ARPA.txt");

			Scanner sc = new Scanner(file);
			int vertexAmount = sc.nextInt();

			for (int i = 0; i < vertexAmount; i++) {
				Vertex location = new Vertex("Node_" + i, "Node_" + i);
				nodes.add(location);
			}

			int i = 0;
			while (sc.hasNext() == true) { // read file (effectively) line by
											// line
				int a = sc.nextInt();
				int b = sc.nextInt();
				double c = sc.nextDouble();
				double d = sc.nextDouble();
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
				System.out.println(d);

				addLane("Edge_" + i, a, b, c, d);
				i++;
			}

			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Lets check from location Loc_1 to Loc_10
		Graph graph = new Graph(nodes, edges);
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
		dijkstra.execute(nodes.get(0));
		LinkedList<Vertex> path = dijkstra.getPath(nodes.get(10));

		// assertNotNull(path);
		// assertTrue(path.size() > 0);

		for (Vertex vertex : path) {
			System.out.println(vertex);
		}

	}

	// public void testExcute() {
	//
	// for (int i = 0; i < 11; i++) {
	// Vertex location = new Vertex("Node_" + i, "Node_" + i);
	// nodes.add(location);
	// }
	//
	// // addLane("Edge_0", 0, 1, 85);
	// // addLane("Edge_1", 0, 2, 217);
	// // addLane("Edge_2", 0, 4, 173);
	// // addLane("Edge_3", 2, 6, 186);
	// // addLane("Edge_4", 2, 7, 103);
	// // addLane("Edge_5", 3, 7, 183);
	// // addLane("Edge_6", 5, 8, 250);
	// // addLane("Edge_7", 8, 9, 84);
	// // addLane("Edge_8", 7, 9, 167);
	// // addLane("Edge_9", 4, 9, 502);
	// // addLane("Edge_10", 9, 10, 40);
	// // addLane("Edge_11", 1, 10, 600);
	//
	//
	//
	// }

	private void addLane(String laneId, int sourceLocNo, int d, double e,
			double dist) {
		Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(d), e,
				dist);
		edges.add(lane);
	}
}