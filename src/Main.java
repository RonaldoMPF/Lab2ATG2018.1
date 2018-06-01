import main.*;
import main.structure.components.Vertex;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        Graph<Integer> graph1;
        Graph<Integer> graph2;
        Graph<Integer> weightedGraph;
        String graph1Path = new File("data/graph1.txt").getAbsolutePath();
        String graph2Path = new File("data/graph2.txt").getAbsolutePath();
        String weightedGraphPath = new File("data/weightedGraph.txt").getAbsolutePath();
        Vertex<Integer> vertexg1;
        Vertex<Integer> vertexg2;
        Vertex<Integer> vertexgw;


        graph1 = new Graph<>();
        graph2 = new Graph<>();
        weightedGraph = new Graph<>();
        graph1.readGraph(graph1Path);
        graph2.readGraph(graph2Path);
        weightedGraph.readWeightedGraph(weightedGraphPath);
        vertexg1 = graph1.getVertex(1L);
        vertexg2 = graph2.getVertex(10L);
        vertexgw = weightedGraph.getVertex(1L);

        System.out.println(graph2.BFS(vertexg2));




    }
}
