import main.structure.components.Edge;
import main.structure.components.Vertex;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by ronanas on 04/06/18.
 */
public class VertexTest {

    private Vertex<Integer> v1;
    private Vertex<Integer> v2;
    private Vertex<Integer> v3;
    private Edge<Integer> e1;
    private Edge<Integer> e2;
    private Edge<Integer> e3;

    @Before
    public void setUp(){
        v1 = new Vertex<>(1L);
        v2 = new Vertex<>(2L, 10);
        v3 = new Vertex<>(3L);
        e1 = new Edge<>(v1, v2);
        e2 = new Edge<>((float)-1.5, v1, v3);
        e3 = new Edge<>((float)3.0, v2, v3);
    }

    @Test
    public void getAndSetTest(){
        assertEquals(v1.getAdjacencyListRepresentation(), "");
        v1.addEdge(e1);
        assertEquals(v1.getAdjacencyListRepresentation(), " 2");
        v1.addEdge(e2);
        assertEquals(v1.getAdjacencyListRepresentation(), " 2 3(-1.5)");
        assertEquals(java.util.Optional.of(1L), Optional.ofNullable(v1.getIndex()));
        assertEquals(java.util.Optional.of(2L), Optional.ofNullable(v2.getIndex()));
        assertEquals(null, v1.getValue());
        assertEquals(Optional.of(10), Optional.ofNullable(v2.getValue()));
        assertEquals(v1.getDistance(), 1.7976931348623157E308, 0.000001);


    }

    @Test
    public void addEdgeTest(){
        v1.addEdge(e1);
        v1.addEdge(e3);
        assertEquals(1, v1.getAdjacencyList().size());
        assertEquals(1, v2.getAdjacencyList().size());
        assertEquals(0, v3.getAdjacencyList().size());
        assertEquals("2", v1.getAdjacencyListRepresentation());
        v3.addEdge(null);
        assertEquals(0, v3.getAdjacencyList().size());
    }

    @Test
    public void removeEdgeTest(){
        v1.addEdge(e1);
        v1.addEdge(e2);
        assertEquals(2, v1.getAdjacencyList().size());
        v1.removeEdge(e3);
        assertEquals(2, v1.getAdjacencyList().size());
        v1.removeEdge(e1);
        assertEquals(1, v1.getAdjacencyList().size());
        v1.removeEdge(e1);
        assertEquals(1, v1.getAdjacencyList().size());
        v1.removeEdge(e2);
        assertEquals(0, v1.getAdjacencyList().size());
    }


}

