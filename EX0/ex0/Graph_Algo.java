package ex0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This class represents the "regular" Graph Theory algorithms including implementations of :
 * • copy
 * • init();
 * • isConnected();
 * • shortestPathDist();
 * • shortestPath();
 * @author denis
 *
 */
public class Graph_Algo implements graph_algorithms {
	private graph g;
	
	public Graph_Algo() {} // complexity --> O(1)

	@Override
	/**
	 * initializes the graph that the algorithms will
	 * work on .
	 * @param g
	 * complexity --> O(1)
	 */
	public void init(graph g) {
		this.g = g;
	}

	@Override
	/**
	 * makes a deep copy of a graph , copies all
	 * the Nodes from one graph to an other , and also
	 * makes the same connections between the Nodes as are 
	 * connected in the graph that the we are copying from. 
	 * complexity --> O(|v|) + O(|v|)*O(|e|) = O(|v|) * O(|e|)
	 */
	public graph copy() {
		Graph_DS copied = new Graph_DS();
		for(node_data n : g.getV()) { // O(|v|)
			copied.addNode(new NodeData(n.getKey())); //O(1)
		}
		for(node_data n : g.getV()) { // O(|v|) 
			for(node_data x : n.getNi()) { //O(|e|)
				copied.connect(n.getKey(), x.getKey());
			}
		}
		return copied;
	}

	@Override
	/**
	 * return true or false either the graph is connected
	 * or not.
	 * uses the BFS (Breadth First Search) algorithm .
	 * this function use Queue as a data structure to store the vertexes
	 * and use also an Iterator .
	 * complexity of BFS algorithm is  --> O(|v|+|e|) + O(|v|) = O(|v|+|e|)
	 */
	public boolean isConnected() {
		if(g == null) return true;
		Queue<node_data> q = new LinkedList<node_data>();
		Iterator<node_data> it = g.getV().iterator();
		boolean flag = true;
		if(g.nodeSize() == 0) return true; //{
		q.add(it.next());
		while(!q.isEmpty()) {
			node_data temp =  q.poll();
			if(temp.getInfo() != "b") temp.setInfo("b");				
			for(node_data t : temp.getNi()) {
				if(t.getInfo()!="b" && t.getInfo()!="g") {
					q.add(t);
					t.setInfo("g");

				}
			}
		}
		//}
		for(node_data n : g.getV()) { //O(|v|)
			if (n.getInfo() != "b") flag = false;
			n.setInfo("");
		}
		return flag;
	}


	@Override
	/**
	 * gets two keys as arguments , one is a source and the other is destination
	 * which the method return the shortest path distance between those
	 * two keys . 
	 * uses the BFS (Breadth First Search) algorithm .
	 * also uses in Queue data structure .
	 * if there is no path between those two keys , the
	 * method will return -1 , else it will return the shortest path distance.
	 * @param src
	 * @param dest
	 * complexity of BFS algorithm is  --> O(|v|+|e|) + O(|v|) = O(|v|+|e|)
	 */
	public int shortestPathDist(int src, int dest) {
		if(!g.getV().contains(g.getNode(dest))) return -1;
		Queue<node_data> q = new LinkedList<node_data>();
		q.add(g.getNode(src));
		while(!q.isEmpty()) {
			node_data temp =  q.poll();
			if(temp.getInfo() != "black") temp.setInfo("black");				
			for(node_data t : temp.getNi()) {
				if(t.getInfo()!="black" && t.getInfo()!="grey") {
					q.add(t);
					t.setInfo("grey");
					t.setTag(temp.getTag()+1);
				}
			}
		}
		int dist = g.getNode(dest).getTag();
		for(node_data n : g.getV()) { // O(|v|)
			n.setInfo("");
			n.setTag(0);
		}
		if(dist != 0) return dist;
		else return -1;
	}

	@Override
	/**
	 * gets two keys as arguments , one is source and the other is destination .
	 * return a List of Nodes which represent the shortest path between those
	 * two keys (source and destination) .
	 * uses the BFS (Breadth First Search) algorithm .
	 * uses a HashMap and a Queue data structures , and a LinkedList .
	 * @param src
	 * @param dest
	 * complexity of BFS algorithm is  --> O(|v|+|e|) + O(distance(source , destination)) = O(|v|+|e|)
	 */
	public List<node_data> shortestPath(int src, int dest) {
		HashMap<node_data, node_data> parents = new HashMap<node_data, node_data>();
		Queue<node_data> q = new LinkedList<node_data>();
		q.add(g.getNode(src));
		while(!q.isEmpty()) {
			NodeData temp = (NodeData) q.poll();
			if(temp.getInfo() != "black") temp.setInfo("black");				
			for(node_data t : temp.getNi()) {
				if(t.getInfo()!="black" && t.getInfo()!="grey") {
					q.add(t);
					parents.put(t, temp);
					t.setInfo("grey");
					t.setTag(temp.getTag()+1);
				}
			}
		}
		List<node_data> listOfThePath = new LinkedList<>();
		node_data tmp = g.getNode(dest);
		while(tmp != null) {
			listOfThePath.add(0, tmp); // O(distance(source , destination))
			tmp = parents.get(tmp);
		}
		for(node_data n : g.getV()) {
			n.setInfo("");
			n.setTag(0);
		}
		return listOfThePath;
	}

}
