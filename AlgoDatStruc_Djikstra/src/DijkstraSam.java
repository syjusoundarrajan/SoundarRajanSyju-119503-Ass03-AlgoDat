import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraSam {

    public int[][] graph;
    public Node[] nodes;

    public static class Node {
        public Node parent;
        public int cost;
        public int id;

        public Node(Node parent, int cost, int id) {
            this.parent = parent;
            this.cost = cost;
            this.id = id;
        }
    }

    public DijkstraSam() {
        graph = new int[][]{ {0,1,0,0,0,0,1,3,0,0,0,0,0,0,0,0,0,0,0,0},
        	 {1,0,45,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,0,0},
        	 {0,2,0,3,0,0,0,0,20,0,0,0,0,0,0,0,0,0,0,0},
        	 {0,0,3,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        	 {0,0,0,1,0,1,0,0,0,10,0,0,0,0,0,0,0,0,0,0},
        	 {0,0,0,0,1,0,0,0,0,0,24,0,0,0,0,0,0,0,0,34},
        	 {1,0,0,0,0,0,0,4,0,0,0,0,0,11,0,0,0,0,0,0},
        	 {3,5,0,0,0,0,4,0,18,0,0,0,30,7,0,0,0,0,0,0},
        	 {0,0,20,0,0,0,0,18,0,2,0,0,0,0,3,0,0,0,0,0},
        	 {0,0,0,0,10,0,0,0,2,0,0,4,0,0,0,0,0,0,0,0},
        	 {0,0,0,0,0,24,0,0,0,0,0,12,0,0,0,0,0,1,0,7},
        	 {0,0,0,0,0,0,0,0,0,4,12,0,8,0,0,8,0,0,0,0},
        	 {0,0,0,0,0,0,0,30,0,0,0,8,0,0,0,0,0,5,0,0},
        	 {0,0,0,0,0,0,11,7,0,0,0,0,0,0,1,0,0,0,0,0},
        	 {0,0,0,0,0,0,0,0,3,0,0,0,0,1,0,29,0,21,0,0},
        	 {0,0,0,0,0,0,0,0,0,0,0,8,0,0,29,0,1,3,0,0},
        	 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0},
        	 {0,0,0,0,0,0,0,0,0,0,1,0,5,0,21,3,1,0,4,0},
        	 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,5},
        	 {0,0,0,0,0,39,0,0,0,0,7,0,0,0,0,0,0,0,5,0}
        };
        nodes = new Node[graph.length];
    }

    public static void main(String[] args) {

        DijkstraSam dijkstra = new DijkstraSam();
        for(int i = 0; i < dijkstra.nodes.length; i++)
            dijkstra.nodes[i] = new Node(null, Integer.MAX_VALUE, i);
        int source = 0;
        int destination = 19;
        dijkstra.shortestPath(source, destination);
        System.out.println("Shortest Distance from " + source + " to " + destination + "  is " + dijkstra.nodes[destination].cost);
        Node temp = dijkstra.nodes[destination];
        System.out.println("Path is ");
        while(temp.parent != null) {
            System.out.print(temp.id + " <--- ");
            temp = temp.parent;
        }
        System.out.println(temp.id);
    }

    public void shortestPath(int source, int destination) {
        Set<Node> visited = new HashSet<>();
        PriorityQueue<Node> pQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });
        nodes[source].cost = 0;
        pQueue.add(nodes[source]);
        while(!pQueue.isEmpty()) {
            Node currVertex = pQueue.poll();
            for(int i = 0; i < graph.length; i++) {
                if(graph[currVertex.id][i]!=0 && !visited.contains(nodes[i]) ) {
                    if(!pQueue.contains(nodes[i])) {
                        nodes[i].cost = currVertex.cost + graph[currVertex.id][i];
                        nodes[i].parent = currVertex;
                        pQueue.add(nodes[i]);
                    }
                    else {
                        nodes[i].cost = Math.min(nodes[i].cost, currVertex.cost + graph[currVertex.id][i]);
                        if(nodes[i].cost == currVertex.cost + graph[currVertex.id][i])
                            nodes[i].parent = currVertex;
                    }
                }
            }
            visited.add(currVertex);
        }
    }
}