import main.Graph;
import main.structure.components.Vertex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class MSTTest {

    Graph<Integer> graph1;
    Graph<Integer> graph2;
    Graph<Integer> weightedGraph;
    Graph<Integer> weightedGraphMst;
    String graph1Path = new File("data/graph1.txt").getAbsolutePath();
    String graph2Path = new File("data/graph2.txt").getAbsolutePath();
    String weightedGraphPath = new File("data/weightedGraph.txt").getAbsolutePath();
    String weightedGraphMsTPath = new File("data/mstGraphText.txt").getAbsolutePath();
    Vertex<Integer> vertexg1;
    Vertex<Integer> vertexg2;
    Vertex<Integer> vertexgw;

    @Before
    public void SetUp() throws Exception{
        graph1 = new Graph<>();
        graph2 = new Graph<>();
        weightedGraph = new Graph<>();
        weightedGraphMst = new Graph<>();
        graph1.readGraph(graph1Path);
        graph2.readGraph(graph2Path);
        weightedGraph.readWeightedGraph(weightedGraphPath);
        weightedGraphMst.readWeightedGraph(weightedGraphMsTPath);

    }


    @Test
    public void MSTTest(){
    	Assert.assertEquals(weightedGraphMst.MST(), "1 - 4\n4 - 3\n3 - 2\n"); //A possible output
        Assert.assertEquals(graph1.MST(), "1 - 2\n2 - 5\n5 - 4\n4 - 3\n"); //A possible output
        Assert.assertEquals(graph2.MST(), "10 - 40\n" +
                "40 - 20\n" +
                "20 - 50\n" +
                "50 - 70\n" +
                "70 - 60\n" +
                "60 - 30\n"); //A possible output
        Assert.assertEquals(weightedGraph.MST(), "3 - 4\n" +
                "1 - 2\n" +
                "2 - 5\n" +
                "4 - 5\n"); //A possible output
    }
}
