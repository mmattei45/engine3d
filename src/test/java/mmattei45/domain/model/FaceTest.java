package mmattei45.domain.model;

import mmattei45.domain.math.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FaceTest {

    @Test
    public void containsPoint() {
        var point0 = new Vector(-0.5, -0.75);
        var point1 = new Vector(0.5, -0.75);
        var point2 = new Vector(0, 0.25);
        var triagle = new Face(point0,  point1, point2);

        assertTrue(triagle.containsPoint(0,0));
        assertFalse(triagle.containsPoint(0.2,0.25));
    }

    @Test
    public void minX() {
        var triagle = getXAxisTriangle(12, 23, 250);
        assertEquals(12, triagle.getMinX());
    }

    @Test
    public void maxX() {
        var triagle = getXAxisTriangle(12, 23, 250);
        assertEquals(250, triagle.getMaxX());
    }

    @Test
    public void minY() {
        var triagle = getYAxisTriangle(7, 77, 340);
        assertEquals(7, triagle.getMinY());
    }

    @Test
    public void maxY() {
        var triagle = getYAxisTriangle(7, 77, 340);
        assertEquals(340, triagle.getMaxY());
    }

    private Face getXAxisTriangle(double x0, double x1, double x2) {
        var point0 = new Vector(x0, 0);
        var point1 = new Vector(x1, 0);
        var point2 = new Vector(x2, 0);
        return new Face(point0,  point1, point2);
    }

    private Face getYAxisTriangle(double y0, double y1, double y2) {
        var point0 = new Vector(0, y0);
        var point1 = new Vector(0, y1);
        var point2 = new Vector(0, y2);
        return new Face(point0,  point1, point2);
    }

}