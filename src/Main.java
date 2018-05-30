import main.*;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        Graph<Integer> graph1 = new Graph<>();
        Graph<Integer> graph2 = new Graph<>();
        String graph1Path = new File("data/graph1.txt").getAbsolutePath();

        graph1.readGraph(graph1Path);
    }
}
