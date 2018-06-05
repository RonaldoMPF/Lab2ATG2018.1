import main.Graph;
import main.structure.components.Vertex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import java.io.File;

public class ConnectedAndShortestPathTest {

    Graph<Integer> graph1;
    Graph<Integer> graph2;
    Graph<Integer> weightedGraph;
    String graph1Path = new File("data/graph1.txt").getAbsolutePath();
    String graph2Path = new File("data/graph2.txt").getAbsolutePath();
    String weightedGraphPath = new File("data/weightedGraph.txt").getAbsolutePath();
    Vertex<Integer> vertex1G1;
    Vertex<Integer> vertex2G1;
    Vertex<Integer> vertex1G2;
    Vertex<Integer> vertex2G2;
    Vertex<Integer> vertex1GW;
    Vertex<Integer> vertex2GW;
    Vertex<Integer> vertex3GW;
    Vertex<Integer> vertex4GW;
    Vertex<Integer> vertex5GW;


    @Before
    public void setUp() throws Exception{
        graph1 = new Graph<>();
        graph2 = new Graph<>();
        
        weightedGraph = new Graph<>();
        
        graph1.readGraph(graph1Path);
        graph2.readGraph(graph2Path);
        
        weightedGraph.readWeightedGraph(weightedGraphPath);
        
        vertex1G1 = graph1.getVertex(1L);
        vertex2G1 = graph1.getVertex(4L);
        
        vertex1G2 = graph2.getVertex(10L);
        vertex2G2 = graph2.getVertex(70L);
        
        vertex1GW = weightedGraph.getVertex(1L);
        vertex3GW = weightedGraph.getVertex(3L);
        vertex2GW = weightedGraph.getVertex(2L);
        vertex4GW = weightedGraph.getVertex(4L);
        vertex5GW = weightedGraph.getVertex(5L);

    }

//    @Test
//    public void isConnectedTest(){
//        Assert.assertFalse(graph1.connected());
//        Assert.assertFalse(graph2.connected());
//        Assert.assertFalse(weightedGraph.connected());
//    }

    @Test
    public void shortestPathTest(){
        
    	Assert.assertEquals(graph1.shortestPath(vertex1G1, vertex2G1), "1 5 4");
        Assert.assertEquals(graph2.shortestPath(vertex2G1, vertex2G2), "10 30 60 70");
    	
    	
        Assert.assertEquals(weightedGraph.shortestPath(vertex1GW, vertex2GW), "1 2 ");
      
        Assert.assertEquals(weightedGraph.shortestPath(vertex1GW, vertex5GW), "1 2 5 ");
        
        Assert.assertEquals(weightedGraph.shortestPath(vertex4GW, vertex3GW), "4 3 ");
        
        Assert.assertEquals(weightedGraph.shortestPath(vertex5GW, vertex3GW), "5 4 3 ");
        
    }


}
