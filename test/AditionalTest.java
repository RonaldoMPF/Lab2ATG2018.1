import main.Graph;
import main.structure.components.Edge;
import main.structure.components.Vertex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.assertEquals;

public class AditionalTest {
    Graph<Integer> graph1;
    Graph<Integer> graph2;
    Graph<Integer> weightedGraph;
    Graph<Integer> giantGraph;
    String graph1Path = new File("data/graph1.txt").getAbsolutePath();
    String graph2Path = new File("data/graph2.txt").getAbsolutePath();
    String weightedGraphPath = new File("data/weightedGraph.txt").getAbsolutePath();
    String giantGraphPath = new File("data/giantGraph.txt").getAbsolutePath();
    Vertex<Integer> vertexg1;
    Vertex<Integer> vertexg2;
    Vertex<Integer> vertexgw;
    Edge<Integer> edgeg1;
    Edge<Integer> edgeg2;
    Edge<Integer> edgegw;

    @Before
    public void SetUp() throws Exception{
        graph1 = new Graph<>();
        graph2 = new Graph<>();
        giantGraph = new Graph<>();
        weightedGraph = new Graph<>();
        graph1.readGraph(graph1Path);
        graph2.readGraph(graph2Path);
        weightedGraph.readWeightedGraph(weightedGraphPath);
        giantGraph.readGraph(giantGraphPath);
        vertexg1 = new Vertex<Integer>(6L);
        vertexg2 = new Vertex<Integer>(80L);
        vertexgw = new Vertex<Integer>(6L);

    }

    @Test
    public void addVertexTest(){
        assertEquals(graph1.getVertexNumber(), 5);
        graph1.addVertex(6L);
        assertEquals(graph1.getVertexNumber(), 6);
        assertEquals(graph2.getVertexNumber(), 7);
        graph2.addVertex(80L);
        assertEquals(graph2.getVertexNumber(), 8);
        assertEquals(weightedGraph.getVertexNumber(), 5);
        weightedGraph.addVertex(6L);
        assertEquals(weightedGraph.getVertexNumber(), 6);

    }

    @Test
    public void addEdgeTest(){
        graph1.addVertex(6L);
        graph2.addVertex(80L);
        weightedGraph.addVertex(6L);

        assertEquals(graph1.getEdgeNumber(), 5);
        graph1.addEdge(5L, 6L);
        assertEquals(graph1.getEdgeNumber(), 6);
        assertEquals(graph2.getEdgeNumber(), 10);
        graph2.addEdge(70L, 80L);
        assertEquals(graph2.getEdgeNumber(), 11);

    }

    @Test
    public void addWeightedEdgeTest(){
        assertEquals(weightedGraph.getEdgeNumber(), 6);
        weightedGraph.addWeightedEdge((float) 1.2, 5L, 6L);
        assertEquals(weightedGraph.getEdgeNumber(), 7);

    }

    @Test
    public void toStringTest(){
        assertEquals(graph1.toString(), "1 - [1-->2, 1-->5]\n" +
                "2 - [2-->1, 2-->5]\n" +
                "3 - [3-->5]\n" +
                "4 - [4-->5]\n" +
                "5 - [5-->2, 5-->3, 5-->4, 5-->1]\n");
        assertEquals(graph2.toString(), "50 - [50-->20, 50-->70]\n" +
                "40 - [40-->10, 40-->20]\n" +
                "20 - [20-->40, 20-->10, 20-->30, 20-->60, 20-->50]\n" +
                "30 - [30-->10, 30-->20, 30-->60]\n" +
                "60 - [60-->20, 60-->30, 60-->70]\n" +
                "10 - [10-->40, 10-->30, 10-->20]\n" +
                "70 - [70-->60, 70-->50]\n");
        assertEquals(weightedGraph.toString(), "5 - [5-->2(0.2), 5-->3(5.0), 5-->4(2.3), 5-->1(1.0)]\n" +
                "3 - [3-->5(5.0), 3-->4(-9.5)]\n" +
                "2 - [2-->1(0.1), 2-->5(0.2)]\n" +
                "4 - [4-->3(-9.5), 4-->5(2.3)]\n" +
                "1 - [1-->2(0.1), 1-->5(1.0)]\n");
    }
}
