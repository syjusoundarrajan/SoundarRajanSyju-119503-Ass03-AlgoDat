
import java.util.ArrayList;
import java.util.HashMap;

/**
 * graphTemplate
 */
public class GraphTemplate {
    ArrayList<Node> nodes;
    ArrayList<Node> minPriorityQueue;

    GraphTemplate(){
        nodes = new ArrayList<Node>();
        minPriorityQueue = new ArrayList<Node>();
        parent = null;
        distance = Integer.MAX_VALUE;
    }

    // TODO: implement additional constructors
    // TODO: implement method for adding a node
    // TODO: implement method for removing a node
    // TODO: implement method for sorting the min-priority Queue
    // TODO: implement method for extracting an element from the min-priority Queue
    // TODO: implement Djikstra (in another class)

}

/**
 * Node
 */
private class Node {
    String label;
    HashMap<Node,Integer> adjacentNodes; // Pair connected node + weight
    Node parent;
    int distance;

    Node(){
        label = "";
        adjacentNodes = new HashMap<Node,Integer>();
    }

    Node(String name){
        label = name;
        adjacentNodes = new HashMap<Node, Integer>();
    }

    // TODO: implement additional constructors
    // TODO: implement method for adding a connection
    // TODO: implement method for removing a connection
    // TODO: implement methods for manipulating the parent and distance

}