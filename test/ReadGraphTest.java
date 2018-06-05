import main.Graph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class ReadGraphTest {

    Graph<Integer> graph1;
    Graph<Integer> graph2;
    Graph<Integer> weightedGraph1;
    Graph<Integer> disconnectedGraph;
    Graph<Integer> emptyGraph;
    Graph<Integer> randomFileGraph;
    Graph<Integer> giantGraph;


    String graph1Path = new File("data/graph1.txt").getAbsolutePath();
    String graph2Path = new File("data/graph2.txt").getAbsolutePath();
    String weightedGraphPath = new File("data/weightedGraph.txt").getAbsolutePath();
    String notAGraphPath = new File("data/notAGraph.txt").getAbsolutePath();
    String disconnectedGraphPath = new File("data/disconnectedGraph.txt").getAbsolutePath();
    String emptyGraphPath = new File("data/emptyGraph.txt").getAbsolutePath();
    String randomFileGraphPath = new File("data/randomFile.txt").getAbsolutePath();
    String giantGraphPath = new File("data/giantGraph.txt").getAbsolutePath();

    @Before
    public void setUp() throws Exception {
        graph1 = new Graph<>();
        graph2 = new Graph<>();
        weightedGraph1 = new Graph<>();
        disconnectedGraph =  new Graph<>();
        emptyGraph = new Graph<>();
        randomFileGraph = new Graph<>();
        giantGraph = new Graph<>();
    }

    @Test
    public void readGraphTest(){
        try{
            graph1.readGraph(graph1Path);
        }catch (Exception e) {
            Assert.fail("Should not throw an exception while reading this graph");
        }

        try{
            graph2.readGraph(graph2Path);
        }catch (Exception e) {
            Assert.fail("Should not throw an exception while reading this graph");
        }

        assertEquals(5, graph1.getEdgeNumber());
        assertEquals(5, graph1.getVertexNumber());

        assertEquals(7, graph1.getEdgeNumber());
        assertEquals(10, graph1.getVertexNumber());

    }

    @Test
    public void readWeightedGraphTest(){
        try{
            weightedGraph1.readWeightedGraph(weightedGraphPath);
        } catch (Exception e) {
            Assert.fail("Should not throw an exception while reading this graph");
        }

        assertEquals(6, weightedGraph1.getEdgeNumber());
        assertEquals(5, weightedGraph1.getVertexNumber());

    }

    @Test
    public void readInvalidGraphTest(){
        try{
            randomFileGraph.readGraph(notAGraphPath);
            Assert.fail("Should throw an exception while reading this graph");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Invalid formatting in input file:\n"
                    + "The formatting should be:\n"
                    + "<graph size number>\n"
                    + "<source> <destination>");
        }

    }
    
    @Test
    public void readInvalidWeightedGraphTest(){
        try{
            randomFileGraph.readWeightedGraph(notAGraphPath);
            Assert.fail("Should throw an exception while reading this graph");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Invalid formatting in input file:\n"
                    + "The formatting should be:\n"
                    + "<graph size number>\n"
                    + "<source> <destination> <weight>");
        }
    }
    
    @Test
    public void readInvalidFileGraphTest(){
        try{
            randomFileGraph.readGraph(randomFileGraphPath);
            Assert.fail("Should throw an exception while reading this graph");
        } catch (Exception e) {
        	e.printStackTrace();
            assertEquals(e.getMessage(), "Invalid formatting in input file:\n"
                    + "The formatting should be:\n"
                    + "<graph size number>\n"
                    + "<source> <destination>");
        }
    }
    
    @Test
    public void readInvalidFileWeitghtedGraphTest(){
        try{
            randomFileGraph.readWeightedGraph(randomFileGraphPath);
            Assert.fail("Should throw an exception while reading this graph");
        } catch (Exception e) {
        	e.printStackTrace();
            assertEquals(e.getMessage(), "Invalid formatting in input file:\n"
                    + "The formatting should be:\n"
                    + "<graph size number>\n"
                    + "<source> <destination> <weight>");
        }
    }

    @Test
    public void readDisconnectedGraphTest(){
        try {
            disconnectedGraph.readGraph(disconnectedGraphPath);
        }catch (Exception e){
            Assert.fail("Should not throw an exception while reading this graph");
        }

        assertEquals(2, disconnectedGraph.getEdgeNumber());
        assertEquals(4, disconnectedGraph.getVertexNumber());

    }
    
    @Test
    public void readEmptyGraphTest(){
        try {
            emptyGraph.readGraph(emptyGraphPath);
        }catch (Exception e){
            Assert.fail("Should not throw an exception while reading this graph");
        }

    }

    @Test
    public void readGiantGraphTest(){
        try {
            giantGraph.readGraph(giantGraphPath);
        }catch (Exception e){
            Assert.fail("Should not throw an exception while reading the graph");
        }

        assertEquals(999, giantGraph.getVertexNumber());
        assertEquals(998, giantGraph.getEdgeNumber());
        assertEquals(1.199799, giantGraph.getMeanEdge(), 0.0001);
    }


}
