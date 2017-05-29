package tr.edu.gtu.bkorkmaz;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Creatin file object to read the graph in file
        File graphData = new File("graph_1.txt");
        Scanner scnr = null;

        try {
            System.out.println("List Graph");
            scnr = new Scanner(graphData );


            // Save to ListGraph object after reading
            ListGraph lgObj = (ListGraph) AbstractGraph.createGraph(scnr, false, "List");

            //Testing First Method and write result to the file
            lgObj.addRandomEdgesToGraph(10);
            lgObj.getConnectedComponentUndirectedGraph();
            lgObj.writeGraphToFile ("graph_1_l");
            lgObj.isBipartiteUndirectedGraph();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("\nMatrix Graph");
            scnr = new Scanner(graphData );

            // Save to ListGraph object after reading
            MatrixGraph mgObj = (MatrixGraph) AbstractGraph.createGraph(scnr, false, "Matrix");

            //Testing First Method and write result to the file
            mgObj.addRandomEdgesToGraph(9);
            mgObj.getConnectedComponentUndirectedGraph();
            mgObj.writeGraphToFile ("graph_1_m");
            mgObj.isBipartiteUndirectedGraph();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nDirected List Graph");
        try {
            scnr = new Scanner(graphData );


            // Save to ListGraph object after reading
            ListGraph lgObj = (ListGraph) AbstractGraph.createGraph(scnr, true, "List");

            //Testing First Method and write result to the file
            lgObj.addRandomEdgesToGraph(10);
            lgObj.getConnectedComponentUndirectedGraph();
            lgObj.writeGraphToFile ("graph_2_l");
            lgObj.isBipartiteUndirectedGraph();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nDirected Matrix Graph");
        try {

            scnr = new Scanner(graphData );

            // Save to ListGraph object after reading
            MatrixGraph mgObj = (MatrixGraph) AbstractGraph.createGraph(scnr, true, "Matrix");

            //Testing First Method and write result to the file
            mgObj.addRandomEdgesToGraph(9);
            mgObj.getConnectedComponentUndirectedGraph();
            mgObj.writeGraphToFile ("graph_2_m");
            mgObj.isBipartiteUndirectedGraph();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
