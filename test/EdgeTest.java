import main.structure.components.Edge;
import main.structure.components.Vertex;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class EdgeTest {

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
        assertEquals(e1.getSource(), v1);
        assertEquals(e2.getDestination(), v3);
        e3.setDestination(v2);
        assertEquals(e3.getDestination(), v2);
        e1.setSource(v2);
        assertEquals(e1.getSource(), v2);
        assertEquals(e1.getWeight(), null);
    }

    @Test
    public void toStringTest(){
        assertEquals("1-->2", e1.toString());
        assertEquals("1-->3(-1.5)", e2.toString());
        assertEquals("2-->3(3.0)", e3.toString());
    }
}
