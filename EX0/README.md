An implementation of an unidirectional unweighted graph.

***Information about NodeData class :***

•`key` is the information that the node holds , `info` is the (meta data) associated with this node , `tag` Temporal data (aka color: e,g, white, gray, black)  which can be used in the algorithms ,`ID` is a static variable that always increases by  1 every time that a new node is built.
the `HashMap` stores the neighbors of a specific node .

•The `getKey()` method returns the key from a specified node .

•The `getNi()` This method uses Collection class . The method returns a collection with all the neighbors of a specified node. `HasNi()`The method gets as an argument an Integer which return a boolean answer either the specified node contains that Key as a neighbor or not. `addNi()` is a method that adds a neighbor to a specified node . The function gets as argument a new NodeData which will be added as a neighbor.

•The`removeNode()` method get as argument a NodeData . The method removes the edge with this key.

•The `getInfo()` method return the info of a specified NodeData , as well `setInfo()` sets the info of a specified NodeData.

•The `getTag()` return the tag of a specified NodeData ,  as well `setTag()` sets the tag of a specified NodeData.

• The `toString() `prints the key value , info value  and the tag value of a specified NodeData.

***Information about graph class :***

•`hs` is an HashMap which holds the vertexes of a specified graph. `numberOfNodes` hold the information of how many nodes there are in a graph.
`numberOfEdged` hold the information of how many edges there are in a graph.
`MC`is a mode counter - counts the amount of changings that happened during building a specified graph.

•The `getNode()`gets an Integer argument which that method return a NodeData by the given key .

•The `hasEdge()`gets as argument two keys , this method return a boolean answer , it will return true if and only if there is an edge between those two Nodes that their keys are given in the argument of this method

•The `addNode()` method gets in the  argument a Node , which the method adds this Node to the graph.  

•The `connect()` gets in the argument two keys and checks if there is a connection between them , if there is , so the method does nothing , else it will connect the two nodes which their keys were given in the argument of the method.

•Two types of `getV()` method : 1) The `getV()` method return all the Nodes of the graph. 2) The `getV()`method that gets a key in the argument will return all the neighbors of a specified Node which the key is defining 

•The `removeNode()` method gets a key as an argument and removes this Node from the graph. also the function removes all the edged that this node had . This method use the Collection class.

•The `removeEdge` method gets two keys as an arguments , this function checks if there is a connection between them , if there is , so it will remove the edge between those nodes so that they wont be neighbors anymore. 

•The `nodeSize()` method return the number of the nodes that are in the specified graph.

•The `edgeSize()` method return the number of the edges that are in the specified graph.

•The `getMC()`method return the number of the amount of changes that were done on the specified graph. 

***information about graph_algorithms :*** 

•The `init()` method Initializing the graph on which the algorithms will work on.

•The `copy()` method is making a deep copy if a specified graph .The method copies all the Nodes and all the connections between them to a new graph.

•The `isConnected()` method return a boolean answer if there is a connection between all the nodes (In other words , if there is a way to get from each node to another) if there is , so the method will return TRUE , but if there isnt , so the method will return FLASE . This method use the BFS (Breadth First Search) algorithm.
On this method there is a use of a Queue and an Iterator , as well use of the previous methods such as `getNode()` , `getV()` , `setInfo()` , `getInfo()` , `setTag()` .

•The `shortestPathDist()` method gets a source and a destination keys as arguments , and the method return the length of the  shortest path between those two , if there is no such path , the method will return -1 which stands for no such path . 
The method use the BFS (Breadth First Search) algorithm principle .On this method there is a use of a Queue and an Iterator , as well use of the previous methods such as `getNode()` , `getV()` , `setInfo()` , `getInfo()` , `setTag()` .

•The `shortestPath()` method gets a source and a destination keys in the argument , and the method return the shortest path between the source to destination as an ordered list of nodes.
The method uses the BFS (Breadth First Search) algorithm principle .
On this method there is a use of a 	Queue , Iterator and a LinkedList , as well use of the previous methods such as `getNode()` , `getV()` , `setInfo()` , `getInfo()` , `setTag()` .

****Links related :**** 
 Breadth First Search wiki : https://en.wikipedia.org/wiki/Breadth-first_search .
 •
