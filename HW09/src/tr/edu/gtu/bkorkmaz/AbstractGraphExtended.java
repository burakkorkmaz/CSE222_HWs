package tr.edu.gtu.bkorkmaz;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by Burak Kağan Korkmaz on 16.05.2017.
 */
public abstract class AbstractGraphExtended extends AbstractGraph {

    private Graph [] graphs;
    private ArrayList< ArrayList<Integer> > graphList = new ArrayList<>();

    private boolean isEqual(ArrayList<Integer> aL1, ArrayList<Integer> aL2){
        boolean found = false;
        int firstSize = aL1.size();
        int secondSize = aL2.size();

        if (firstSize != secondSize) {
            return found;
        }

        for (Integer anInt : aL1) {
            found = false;
            for (int j = 0; j < secondSize || !found; j++) {
                if (Objects.equals(anInt, aL2.get(j)))
                    found = true;
            }
        }
        return found;
    }

    public AbstractGraphExtended(int numV, boolean directed) {
        super(numV, directed);
    }

    /**
     * This method selects a random number between 0 and edgeLimit then adds that much edges to calling
     * graph. The source and destination vertices of edges are random again.
     * The inserted edges are directed or undirected according to calling graph
     * (If graph is directed, new edges are directed vice versa).
     * The weights of edges sets to 1.
     *
     * @param edgeLimit max length of edge.
     * @return number of inserted edges.
     */
    public int addRandomEdgesToGraph(int edgeLimit) {

        int randomNum = (int) (Math.random() * edgeLimit);
        int addedEgde = 0;

        for (int i = 0; i < randomNum; i++) {
            int randomSource;
            int randomDest;
            randomSource = (int) (Math.random() * getNumV());
            randomDest = (int) (Math.random() * getNumV());
//                System.out.printf("test: %d %d\n",randomSource,randomDest);
            if (!isEdge(randomSource,randomDest)) {
                ++addedEgde;
                System.out.printf("%d->%d\n", randomSource, randomDest);
                insert(new Edge(randomSource, randomDest, 1.0));
            }
        }
        System.out.println("Egdes added: " + addedEgde);
        return addedEgde;
    }

    /**
     * This method performs a breadth first search on calling graph starting from vertex start.
     * It works for both directed and undirected graphs.
     *
     * @param start first vertex.
     * @return array which contains the predecessor of each vertex
     * in the breadth-first search tree.
     */
    public int[] breadthFirstSearch(int start) {

        Queue<Integer> theQueue = new LinkedList<Integer>();
        // Declare array parent and initialize its elements to 1.
        int[] parent = new int[getNumV()];
        for (int i = 0; i < getNumV(); i++) {
            parent[i] = -1;
        }
        // Declare array identified and
        // initialize its elements to false.
        boolean[] identified = new boolean[getNumV()];
    /* Mark the start vertex as identified and insert it
       into the queue */
        identified[start] = true;
        theQueue.offer(start);
    /* While the queue is not empty */
        while (!theQueue.isEmpty()) {
      /* Take a vertex, current, out of the queue.
       (Begin visiting current). */
            int current = theQueue.remove();
      /* Examine each vertex, neighbor, adjacent to current. */
            Iterator<Edge> itr = edgeIterator(current);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                int neighbor = edge.getDest();
                // If neighbor has not been identified
                if (!identified[neighbor]) {
                    // Mark it identified.
                    identified[neighbor] = true;
                    // Place it into the queue.
                    theQueue.offer(neighbor);
          /* Insert the edge (current, neighbor)
             into the tree. */
                    parent[neighbor] = current;
                }
            }
            // Finished visiting current.
        }
        return parent;
    }

    /**
     * This method finds connected components in a graph, creates ListGraph or
     * MatrixGraph instances for each connected component and returns them in a Graph array.
     * If this method is called from a ListGraph instance, then connected components will be
     * ListGraph instances. Same thing will happen for MatrixGraph instance.
     * The method only works for undirected graphs.
     * @return a Graph array or null if directed graph called.
     */
    public Graph[] getConnectedComponentUndirectedGraph() {
        if(isDirected()){
            System.err.println("The getConnected method only works for undirected graphs.");
            return null;
        }

        int numGraph = 0;
        for (int i = 0; i < getNumV(); i++) {
            int [] graph = breadthFirstSearch(i);
//            System.out.println("\nParent Array");
//            System.out.println(Arrays.toString(graph));
            ArrayList<Integer> related = new ArrayList<>();
            related.add(i);
            for (int j = 0; j < getNumV(); j++) {
                if(graph[j] != -1)
                    related.add(j);
            }
//            System.out.println("Related Vertices:" + related);
            graphList.add(related);
            ++numGraph;
            for (int j = 0;
                 numGraph > 1 && j < numGraph;
                 j++) {
                if(j != numGraph -1 && isEqual(graphList.get(numGraph - 1),
                    graphList.get(j))){

                    graphList.remove(numGraph - 1);
                    --numGraph;
                }
            }
        }
        System.out.println("\nNumber of Graphs:" + numGraph);
        System.out.println(graphList);
        graphs = new Graph[numGraph];

        for (int i = 0; i < numGraph; i++) {
            int numOfVertex = graphList.get(i).size();
            if(this instanceof ListGraph)
                graphs[i] = new ListGraph(numOfVertex, isDirected());
            else
                graphs[i] = new MatrixGraph(numOfVertex, isDirected());

            for (int j = 0; j < numOfVertex; j++) {
                for (int k = 0; k < numOfVertex; k++) {
                    int currSource = graphList.get(i).get(j);
                    int currDest = graphList.get(i).get(k);
                    if(isEdge(currSource,currDest)) {
//                        System.out.println(j + " " + k);
                        if (!isDirected()) {
                            if (!graphs[i].isEdge(j, k)) {
                                getEdge(j,k);
                                Edge edge = new Edge(j, k, 1.0);
                                graphs[i].insert(edge);
                            }
                        }
                        else {
                            getEdge(j,k);
                            Edge edge = new Edge(j, k, 1.0);
                            graphs[i].insert(edge);
                            }

                    }

                }
            }
        }

        return graphs;
    }

    /**
     * A bipartite graph is a graph whose vertices can be divided into two independent sets,
     * U and V such that every edge (u, v) either connects a vertex from U to V or a vertex from V to U
     *
     * @return true if calling graph instance is bipartite graph, false otherwise.
     * Uses boolean array for each discrete graph.
     */
    public boolean[] isBipartiteUndirectedGraph() {

        if(isDirected()){
            System.err.println("The Bipartite method only works for undirected graphs.");
            return null;
        }

        boolean [] booleans = new boolean[graphs.length];
        for (int i = 0; i < graphs.length; i++) {
            if(graphs[i].getNumV() < 3)
                booleans[i] = true;
            else
                booleans[i] = false;
        }

        return booleans;
    }


    /**
     * This method does the reverse of createGraph method in the AbstractGraph abstract class and write
     * number of vertices, source and destination vertex of each edge in a file.
     * Creates different file for each discrete graph.
     *
     * @param fileName Name of the file that includes vertex and edges
     */
    public void writeGraphToFile(String fileName) throws IOException {

        if(isDirected()){
            FileWriter fileWriter = new FileWriter(fileName + ".txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            int vertex = getNumV();
            bufferedWriter.write(vertex + "\n");
//            System.out.println("numV: " + vertex);
            for (int i = 0; i < vertex; i++) {
                Iterator<Edge> edgeIterator = edgeIterator(i);
                while (edgeIterator.hasNext()) {
                    Edge edge = edgeIterator.next();
//                    System.out.println(edge.getSource() + " " + edge.getDest());
                    bufferedWriter.write(String.valueOf(edge.getSource() + " "));
                    bufferedWriter.write(String.valueOf(edge.getDest()) + "\n");
                }
            }
            bufferedWriter.close();
            fileWriter.close();
        }
        else {
//        System.out.println(graphList.size());
            for (int i = 0; i < graphList.size(); i++) {
                FileWriter fileWriter = new FileWriter(fileName + i + ".txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                int vertex = graphs[i].getNumV();
                bufferedWriter.write(vertex + "\n");
//            System.out.println("numV: " + vertex);
                for (int j = 0; j < vertex; j++) {

                    Iterator<Edge> edgeIterator = graphs[i].edgeIterator(j);
                    while (edgeIterator.hasNext()) {

                        Edge edge = edgeIterator.next();
//                    System.out.println(edge.getSource() + " " + edge.getDest());
                        bufferedWriter.write(String.valueOf(edge.getSource()));
                        bufferedWriter.write(" ");
                        bufferedWriter.write(String.valueOf(edge.getDest()));
                        bufferedWriter.write("\n");
                    }
                }
                bufferedWriter.close();
                fileWriter.close();
            }
        }
    }
}
