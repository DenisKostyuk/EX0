package ex0;
import java.util.Collection;
import java.util.HashMap;

/**
 * this class represents the unweighed and undirected graph
 * including implementations of:
 * • getNode()
 * • hasEdge()
 * • addNode()
 * • connect()
 * • getV()
 * • removeNode()
 * • removeEdge()
 * • nodeSize()
 * • edgeSize()
 * • getMC()
 * @author denis
 *
 */
/**
 * hs is a HashMap data structure that stores all the vertexes
 * in the graph.
 * numberOfNodes represents the number of the Nodes that are
 * in the graph.
 * numberOfEdges represents the number of the edges that are
 * in the graph.
 */
public class Graph_DS implements graph {
	private HashMap<Integer, node_data> hs;
	private int numberOfNodes = 0;
	private int numberOfEdges = 0;
	private int MC = 0;
/**
 * implementation of a graph.
 * uses HashMap data structure to store all the vertexes.
 * complexity --> O(1)
 */
	public Graph_DS () {
		this.hs = new HashMap<>();
	}
	@Override
	/**
	 * gets a key as argument and return the
	 * specified Node with this key.  
	 * @param key
	 * complexity --> O(1)
	 */
	public node_data getNode(int key) {
		return hs.get(key);
	}
	@Override
	/**
	 * return true or false if there is an edge
	 * between two Nodes which their keys
	 * were given in the argument.
	 * @param node1
	 * @param node2
	 * complexity --> O(1)
	 */
	public boolean hasEdge(int node1, int node2) {
		return hs.get(node1).hasNi(node2) && hs.get(node2).hasNi(node1);
	}
	@Override
	/**
	 * gets a Node as argument and adds it to the
	 * graph.
	 * @param n
	 * complexity --> O(1)
	 */
	public void addNode(node_data n) {
		if(hs.containsKey(n.getKey()) != true) {
			hs.put(n.getKey(), n);
			numberOfNodes ++;
			MC++;
		}
	}
	@Override
	/**
	 * gets two keys and connect those two Nodes
	 * so that they will be neighbors .
	 * @param node1
	 * @param node2
	 * complexity --> O(1)
	 */
	public void connect(int node1, int node2) {
		if(hs.get(node1).hasNi(node2)  == true) return; 
		if(node1 == node2) return;
		//else {
		hs.get(node1).addNi(hs.get(node2));
		hs.get(node2).addNi(hs.get(node1));
		//}
		numberOfEdges++;
		MC++;
	}
	@Override
	/**
	 * returns a collection of all the Nodes 
	 * in the graph.
	 * complexity --> O(1)
	 */
	public Collection<node_data> getV() {
		return hs.values();
	}
	@Override
	/**
	 * gets a key as argument and return all his 
	 * neighbors.
	 * @param node_id
	 * complexity --> O(1)
	 */
	public Collection<node_data> getV(int node_id) {
		return hs.get(node_id).getNi();
	}
	@Override
	/**
	 * gets a key and removes this Node from the graph , 
	 * as well also disconnects all his neighbors from him.
	 * @param key
	 * complexity --> O(|e|) ===>  not all the edges , but the edges that are referred to the specified Node.  
	 */
	public node_data removeNode(int key) {
		if(hs.containsKey(key) != true) return null; 
		Collection<node_data> cln = getNode(key).getNi();
		for(node_data runner : cln) {  //O(|e|)
			hs.get(runner.getKey()).removeNode(getNode(key));
			numberOfEdges--;
		}
		node_data ret = getNode(key);
		hs.remove(key);
		MC++;
		numberOfNodes--;
		return ret;
	}
	@Override
	/**
	 * gets two keys as arguments and removes the edge between
	 * those two vertexes that their keys were given in the argument.
	 * @param node1
	 * @param node2
	 * complexity --> O(|e|) + O(|e|) = O(2|e|) = O(|e|) similar to the removeNode complexity.
	 */
	public void removeEdge(int node1, int node2) {
		if(getNode(node1).hasNi(node2)) {
			getNode(node1).removeNode(getNode(node2));
			getNode(node2).removeNode(getNode(node1));
			MC++;
			numberOfEdges--;
		}
	}
	@Override
	/**
	 * return the number of Nodes in the graph.
	 * complexity --> O(1)
	 */
	public int nodeSize() {
		return numberOfNodes;
	}

	@Override
	/**
	 * return the number of edges in the graph.
	 * complexity --> O(1)
	 */
	public int edgeSize() {
		return numberOfEdges;
	}
	@Override
	/**
	 * return the number of changes that were
	 * done on a specified graph.
	 * complexity --> O(1)
	 */
	public int getMC() {
		return MC;
	}
}
