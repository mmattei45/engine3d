package mmattei45.domain.model;

import mmattei45.domain.math.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelLoaderTest {

    private static final String FILE_PATH = "cubeTest.obj";
    private static final Vector EXPECTED_7TH_VECTOR = new Vector(-0.2, 0, 0.2);
    private static final Vector EXPECTED_3TH_NORMAL = new Vector(-1, 0, 0);

    @Test
    public void shouldLoadFaces() {
        var m = ModelLoader.loadModel(FILE_PATH);
        assertEquals(12, m.getFaces().size());

        var face = m.getFaces().get(2);
        assertEquals(face.getMinX(), -0.2, 0.1);
        assertEquals(face.getMaxX(), -0.2, 0.1);
        assertEquals(face.getMinY(), -0.2, 0.1);
        assertEquals(face.getMaxY(), 0, 0.1);
    }

    @Test
    public void shouldLoadVertexes() {
        var m = ModelLoader.loadModel(FILE_PATH);
        assertEquals(8, m.getVertexes().size());

        var vertex = m.getVertex(6);
        assertVEquals(EXPECTED_7TH_VECTOR, vertex);
    }

    @Test
    public void shouldLoadNormals() {
        var m = ModelLoader.loadModel(FILE_PATH);
        assertEquals(6, m.getNormals().size());

        var normal = m.getNormal(2);
        assertVEquals(EXPECTED_3TH_NORMAL, normal);
    }

    private void assertVEquals(Vector expected, Vector actual) {
        assertEquals(expected.getX(), actual.getX(), 0.001);
        assertEquals(expected.getY(), actual.getY(), 0.001);
        assertEquals(expected.getZ(), actual.getZ(), 0.001);
    }

}