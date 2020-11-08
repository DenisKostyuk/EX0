package ex0;
import java.util.Collection;
import java.util.HashMap;

/**
 * Class that represents a NodeData,and
 * also represents a collection of his neighbors.
 * including implementations of:
 * • NodeData()
 * • getKey()
 * • getNi()
 * • hasNi()
 * • addNi()
 * • removeNode()
 * • getInfo()
 * • setInfo()
 * • getTag()
 * • setTag()
 * • toString()
 * 
 * @author denis
 *
 */

/**
 * key is the key of a Node , id always increases by 1 every time a new Node was built,
 * hs is a HashMap data structure that stores all the Nodes that are built in this project
 * Info is (meta data) associated with this node and the Tag allows setting the "tag" value for temporal marking an node.
 */
public class NodeData implements node_data{
	private  int key = 0;
	private static int id = 0;
	private HashMap<Integer, node_data> hs;
	private String info;
	private int tag;
	/**
	 * implementation of an object type Node thats gets a key as
	 * argument and sets the key to this Node.
	 * @param key
	 * complexity --> O(1)
	 */
	public NodeData(int key) {
		this.key = key;
		this.hs = new HashMap<>();
		this.info = null;
		this.tag = 0;
	}
	/**
	 * implementation of a Node.
	 * the key is the id which increases by 1 every time a new Node
	 * is built.
	 * complexity --> O(1)
	 */
	public NodeData() {
		this.key = id++;
		this.hs = new HashMap<>();
		this.info = null;
		this.tag = 0;
	}
	/**
	 * returns the key of a specified Node.
	 * complexity --> O(1)
	 */
	public int getKey() {
		return this.key;
	}
	/**
	 * return a collection of the neighbors of a specified Node.
	 * complexity --> O(1)
	 */
	public Collection<node_data> getNi(){
		return hs.values();
	}
	@Override
	/**
	 * gets a key as argument and
	 * checks if this key is a neighbor of
	 * a specified Node.
	 * @param key
	 * complexity --> O(1)
	 */
	public boolean hasNi(int key) {
		return hs.containsKey(key);
	}
	@Override
	/**
	 * gets a Node as a argument and adds it
	 * to the neighbors on a specified Node.
	 * @param t
	 * complexity --> O(1)
	 */
	public void addNi(node_data t) {
		hs.put(t.getKey(), t);

	}
	@Override
	/**
	 * gets a Node as argument and deletes this Node.
	 * @param  node
	 * complexity --> O(1)
	 */
	public void removeNode(node_data node) {
		hs.remove(node.getKey());
	}
	@Override
	/**
	 * gets the info of a Node.
	 * complexity --> O(1)
	 */
	public String getInfo() {
		return this.info;
	}
	@Override
	/**
	 * gets a String as argument and sets
	 * the info of a specified Node with this argument.
	 * @param s
	 * complexity --> O(1)
	 */
	public void setInfo(String s) {
		this.info = s;

	}
	@Override
	/**
	 * gets the tag of a specified Node.
	 * complexity --> O(1)
	 */
	public int getTag() {
		return this.tag;
	}
	@Override
	/**
	 * get an integer as an argument and sets
	 * the tag of a specified Node with this number.
	 * @param t
	 * complexity --> O(1)
	 */
	public void setTag(int t) {
		this.tag = t;
	}
	/**
	 * Prints the visualization of a Node
	 * complexity --> O(1)
	 */
	public String toString() {
		return "Key : " + this.key +" " +"Info : " + this.info +" Tag : " + this.tag;
	}
}
