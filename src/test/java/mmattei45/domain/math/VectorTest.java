package mmattei45.domain.math;

import org.ejml.simple.SimpleMatrix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VectorTest {

    @Test
    public void rotate2d() {
        var vector = new Vector(1, 2);
        var matrix = MatrixFactory.rotation(0, 0, 45);

        vector.transform(matrix);

        assertEquals(-0.707, vector.getX(), 0.001);
        assertEquals(2.121, vector.getY(), 0.001);
    }

    @Test
    public void rotate3d() {
        var vector = new Vector(2, 2, 1);
        var matrix = MatrixFactory.rotation(45, 45, 45);

        vector.transform(matrix);

        assertEquals(0.707, vector.getX(), 0.001);
        assertEquals(1.5, vector.getY(), 0.001);
        assertEquals(2.5, vector.getZ(), 0.001);
    }

    @Test
    public void dotProduct() {
        var a = new Vector(1, 0, -2);
        var b = new Vector(3, -1, 1);

        assertEquals(1, a.dotProduct(b));
        assertEquals(1, b.dotProduct(a));
    }

    @Test
    public void magnitude() {
        var vector = new Vector(1, 0, -2);

        assertEquals(Math.sqrt(5), vector.magnitude(), 0.001);
    }

    @Test
    public void angle() {
        var a = new Vector(1, 0, -2);
        var b = new Vector(3, -1, 1);

        assertEquals(82.25, a.angle(b), 0.001);
    }

}