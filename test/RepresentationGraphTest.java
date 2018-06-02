import main.Graph;
import main.structure.components.enums.RepresentationType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class RepresentationGraphTest {

    Graph<Integer> graph1;
    Graph<Integer> graph2;
    Graph<Integer> weightedGraph;
    String graph1Path = new File("data/graph1.txt").getAbsolutePath();
    String graph2Path = new File("data/graph2.txt").getAbsolutePath();
    String weightedGraphPath = new File("data/weightedGraph.txt").getAbsolutePath();
    String notAGraphPath = new File("data/notAGraph.txt").getAbsolutePath();

    @Before
    public void setUp() throws Exception {
        graph1 = new Graph<>();
        graph2 = new Graph<>();
        weightedGraph = new Graph<>();
        graph1.readGraph(graph1Path);
        graph2.readGraph(graph2Path);
        weightedGraph.readWeightedGraph(weightedGraphPath);
    }

    @Test
    public void AdjListTest(){
        try {
            Assert.assertEquals(graph1.graphRepresentation(RepresentationType.ADJACENCYLIST), "1 - 2 5\n" +
                    "2 - 1 5\n" +
                    "5 - 2 3 4 1\n" +
                    "4 - 5\n" +
                    "3 - 5\n");
        } catch (Exception e) {
            Assert.fail();
        }
        try {
            Assert.assertEquals(graph2.graphRepresentation(RepresentationType.ADJACENCYLIST), "30 - 10 20 60\n" +
                    "20 - 40 10 30 60 50\n" +
                    "10 - 40 30 20\n" +
                    "60 - 20 30 70\n" +
                    "50 - 20 70\n" +
                    "70 - 60 50\n" +
                    "40 - 10 20\n");
        } catch (Exception e) {
            Assert.fail();
        }
        try {
            Assert.assertEquals(weightedGraph.graphRepresentation(RepresentationType.ADJACENCYLIST), "1 - 2(0.1) 5(1.0)\n" +
                    "2 - 1(0.1) 5(0.2)\n" +
                    "5 - 2(0.2) 3(5.0) 4(2.3) 1(1.0)\n" +
                    "3 - 5(5.0) 4(-9.5)\n" +
                    "4 - 3(-9.5) 5(2.3)\n");
        } catch (Exception e) {
            Assert.fail();
        }

    }

    @Test
    public void AdjMatrixTest(){
        try {
            Assert.assertEquals(graph1.graphRepresentation(RepresentationType.ADJACENCYMATRIX), "  1 2 3 4 5 \n" +
                    "1 0 1 0 0 1 \n" +
                    "2 1 0 0 0 1 \n" +
                    "3 0 0 0 0 1 \n" +
                    "4 0 0 0 0 1 \n" +
                    "5 1 1 1 1 0 \n");
        } catch (Exception e) {
            Assert.fail();
        }

        try {
            Assert.assertEquals(weightedGraph.graphRepresentation(RepresentationType.ADJACENCYMATRIX), "  1 2 3 4 5 \n" +
                    "1 0 0.1 0 0 1 \n" +
                    "2 0.1 0 0 0 0.2 \n" +
                    "3 0 0 0 -9.5 5 \n" +
                    "4 0 0 -9.5 0 2.3 \n" +
                    "5 1 0.2 5 2.3 0 \n");
        } catch (Exception e) {
            Assert.fail();
        }

    }
}
