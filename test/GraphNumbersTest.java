import main.Graph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class GraphNumbersTest {
    Graph<Integer> graph1;
    Graph<Integer> graph2;
    Graph<Integer> weightedGraph;
    String graph1Path = new File("data/graph1.txt").getAbsolutePath();
    String graph2Path = new File("data/graph2.txt").getAbsolutePath();
    String weightedGraphPath = new File("data/weightedGraph.txt").getAbsolutePath();

    @Before
    public void SetUp() throws Exception{
        graph1 = new Graph<>();
        graph2 = new Graph<>();
        weightedGraph = new Graph<>();
        graph1.readGraph(graph1Path);
        graph2.readGraph(graph2Path);
        weightedGraph.readWeightedGraph(weightedGraphPath);
    }

    @Test
    public void getVertexNumberTest(){
        Assert.assertEquals(graph1.getVertexNumber(), 5);
        Assert.assertEquals(graph2.getVertexNumber(), 7);
        Assert.assertEquals(weightedGraph.getVertexNumber(), 5);
    }

    @Test
    public void getEdgeNumberTest(){
        Assert.assertEquals(graph1.getEdgeNumber(), 5);
        Assert.assertEquals(graph2.getEdgeNumber(), 10);
        Assert.assertEquals(weightedGraph.getEdgeNumber(), 6);
    }

    @Test
    public void getMeanEdgeTest(){
        Assert.assertEquals(graph1.getMeanEdge(), 2, 0.01);
        Assert.assertEquals(graph2.getMeanEdge(), 2.8, 0.01);
        Assert.assertEquals(weightedGraph.getMeanEdge(), 2.4, 0.01);
    }
}
