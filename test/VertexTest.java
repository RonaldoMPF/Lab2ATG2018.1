import main.structure.components.Edge;
import main.structure.components.Vertex;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ronanas on 04/06/18.
 */
public class VertexTest {
    Vertex<Integer> v1;
    Vertex<Integer> v2;
    Vertex<Integer> v3;
    Vertex<Integer> v4;

    @Before
    public void setUp(){
        v1 = new Vertex<Integer>(1L);
        v2 = new Vertex<Integer>(2L, 10);
        v3 = new Vertex<Integer>(3L);

    }

    @Test
    public void addEgeTest(){
        v1.addEdge(new Edge<>(v1,  v2));
        v1.addEdge(new Edge<>(v2,  v3));
        assertEquals(1, v1.getAdjacencyList().size());
        assertEquals(1, v2.getAdjacencyList().size());
        assertEquals(0, v3.getAdjacencyList().size());
        v3.addEdge(null);
        assertEquals(0, v3.getAdjacencyList().size());
    }

    @Test
    public void removeEdgeTest(){
        v1.addEdge(new Edge<>(v1,  v2));
        v1.addEdge(new Edge<>(v1,  v3));
        assertEquals(2, v1.getAdjacencyList().size());;
    }
}

