package mmattei45.domain.model;


import mmattei45.domain.math.Vector;
import org.ejml.simple.SimpleMatrix;

public class Face {

    private Vector[] vertexes = new Vector[3];
    private Vector vertexA;
    private Vector vertexB;
    private Vector vertexC;

    public Face(Vector vertexA, Vector vertexB, Vector vertexC) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
        vertexes[0] = vertexA;
        vertexes[1] = vertexB;
        vertexes[2] = vertexC;
    }

    public void transform(SimpleMatrix matrix) {
        for (Vector p : vertexes) {
            p.transform(matrix);
        }
    }

    public boolean containsPoint(double x, double y) {
        double wv1 = ((vertexB.y - vertexC.y) * (x - vertexC.x) +
                (vertexC.x - vertexB.x) * (y - vertexC.y)) /
                ((vertexB.y - vertexC.y) * (vertexA.x - vertexC.x) +
                        (vertexC.x - vertexB.x) * (vertexA.y - vertexC.y));

        double wv2 = ((vertexC.y - vertexA.y) * (x - vertexC.x) +
                (vertexA.x - vertexC.x) * (y - vertexC.y)) /
                ((vertexB.y - vertexC.y) * (vertexA.x - vertexC.x) +
                        (vertexC.x - vertexB.x) * (vertexA.y - vertexC.y));

        double wv3 = 1.0 - wv1 - wv2;

        boolean one = (wv1 < -0.01);
        boolean two = (wv2 < -0.01);
        boolean three = (wv3 < -0.01);

        //is the point in the triangle
        return ((one == two) && (two == three));
    }

    public Face getToScreenCords(int width, int height) {
        int halfWidth = width / 2;
        int halfHeight = height / 2;

        return new Face(
                new Vector((vertexA.x * halfWidth )+ halfWidth, -(vertexA.y * halfHeight) + halfHeight),
                new Vector((vertexB.x * halfWidth) + halfWidth, -(vertexB.y * halfHeight) + halfHeight),
                new Vector((vertexC.x * halfWidth) + halfWidth, -(vertexC.y * halfHeight) + halfHeight)
        );
    }

    public double getMinX() {
        double min = vertexA.x;
        for (Vector p : vertexes) {
            if (p.x < min) min = p.x;
        }
        return min;
    }

    public double getMaxX() {
        double max = vertexA.x;
        for (Vector p : vertexes) {
            if (p.x > max) max = p.x;
        }
        return max;
    }

    public double getMinY() {
        double min = vertexA.y;
        for (Vector p : vertexes) {
            if (p.y < min) min = p.y;
        }
        return min;
    }

    public double getMaxY() {
        double max = vertexA.y;
        for (Vector p : vertexes) {
            if (p.y > max) max = p.y;
        }
        return max;
    }

}
