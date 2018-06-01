import main.Graph;
import main.structure.components.Vertex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.io.File;

public class BFSandDFSTest {

    Graph<Integer> graph1;
    Graph<Integer> graph2;
    Graph<Integer> weightedGraph;
    String graph1Path = new File("data/graph1.txt").getAbsolutePath();
    String graph2Path = new File("data/graph2.txt").getAbsolutePath();
    String weightedGraphPath = new File("data/weightedGraph.txt").getAbsolutePath();
    Vertex<Integer> vertexg1;
    Vertex<Integer> vertexg2;
    Vertex<Integer> vertexgw;

    @Before
    public void setUp() throws Exception {
        graph1 = new Graph<>();
        graph2 = new Graph<>();
        weightedGraph = new Graph<>();
        graph1.readGraph(graph1Path);
        graph2.readGraph(graph2Path);
        weightedGraph.readWeightedGraph(weightedGraphPath);
        vertexg1 = graph1.getVertex(1L);
        vertexg2 = graph2.getVertex(10L);
        vertexgw = weightedGraph.getVertex(1L);
    }

    @Test
    public void bfsTest(){
        Assert.assertEquals(graph1.BFS(vertexg1), "1 - - 0\n" +
                "2 - 1 1\n" +
                "5 - 1 1\n" +
                "3 - 2 5\n" +
                "4 - 2 5\n");
        Assert.assertEquals(graph2.BFS(vertexg2), "10 - - 0\n" +
                "40 - 1 10\n" +
                "30 - 1 10\n" +
                "20 - 1 10\n" +
                "60 - 2 30\n" +
                "50 - 2 20\n" +
                "70 - 3 60\n");
        try{
            graph1.BFS(vertexg2);
            Assert.fail();
        } catch (Exception e){

        }

        try{
            graph2.BFS(vertexg1);
            Assert.fail();
        } catch (Exception e){

        }

    }

    @Test
    public void bfsWeightedGraphTest(){
        Assert.assertEquals(weightedGraph.BFS(vertexgw), "1 - - 0\n" +
                "2 - 1 1\n" +
                "5 - 1 1\n" +
                "3 - 2 5\n" +
                "4 - 2 5\n");
    }

    @Test
    public void dfsGraphTest(){
        Assert.assertEquals(graph1.DFS(vertexg1), "1 - - 0\n" +
                "5 - 1 1\n" +
                "4 - 5 2\n" +
                "3 - 5 1\n" +
                "2 - 1 0\n");
        Assert.assertEquals(graph2.DFS(vertexg2), "10 - - 0\n" +
                "20 - 10 1\n" +
                "50 - 20 2\n" +
                "70 - 50 3\n" +
                "60 - 70 4\n" +
                "30 - 60 5\n" +
                "40 - 10 1\n");
        try{
            graph1.DFS(vertexg2);
            Assert.fail();
        } catch (Exception e){

        }

        try{
            graph2.DFS(vertexg1);
            Assert.fail();
        } catch (Exception e){

        }

    }

    @Test
    public void dfsWeightedGraphTest(){
        Assert.assertEquals(weightedGraph.DFS(vertexgw), "1 - - 0\n" +
                "5 - 1 1\n" +
                "4 - 5 2\n" +
                "3 - 5 1\n" +
                "2 - 1 0\n");
    }

    
}
