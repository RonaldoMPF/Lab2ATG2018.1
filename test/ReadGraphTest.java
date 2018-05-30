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
    String graph1Path = new File("data/graph1.txt").getAbsolutePath();
    String graph2Path = new File("data/graph2.txt").getAbsolutePath();
    String weightedGraphPath = new File("data/weightedGraph1.txt").getAbsolutePath();
    String notAGraphPath = new File("data/notAGraph.txt").getAbsolutePath();

    @Before
    public void setUp() throws Exception {
        graph1 = new Graph<>();
        graph2 = new Graph<>();
        weightedGraph1 = new Graph<>();
    }

    @Test
    public void readGraphTest(){
        try{
            graph1.readGraph(graph1Path);
        }catch (Exception e) {
            Assert.fail();
        }

        try{
            graph2.readGraph(graph2Path);
        }catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void readWeightedGraphTest(){
        try{
            weightedGraph1.readWeightedGraph(weightedGraphPath);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void notAGraphTest(){
        try{
            graph1.readGraph(notAGraphPath);
            Assert.fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Invalid formatting in input file:\n"
                    + "The formatting should be:\n"
                    + "<graph size number>\n"
                    + "<source> <destination>");
        }
    }
}