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

    public Face getTransformed(SimpleMatrix matrix) {
        var vector0 = vertexA.getTransformed(matrix);
        var vector1 = vertexB.getTransformed(matrix);
        var vector2 = vertexC.getTransformed(matrix);

        return new Face(vector0, vector1, vector2);
    }

    public boolean containsPoint(double x, double y) {
        double wv1 = ((vertexB.getY() - vertexC.getY()) * (x - vertexC.getX()) +
                (vertexC.getX() - vertexB.getX()) * (y - vertexC.getY())) /
                ((vertexB.getY() - vertexC.getY()) * (vertexA.getX() - vertexC.getX()) +
                        (vertexC.getX() - vertexB.getX()) * (vertexA.getY() - vertexC.getY()));

        double wv2 = ((vertexC.getY() - vertexA.getY()) * (x - vertexC.getX()) +
                (vertexA.getX() - vertexC.getX()) * (y - vertexC.getY())) /
                ((vertexB.getY() - vertexC.getY()) * (vertexA.getX() - vertexC.getX()) +
                        (vertexC.getX() - vertexB.getX()) * (vertexA.getY() - vertexC.getY()));

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
                new Vector((vertexA.getX() * halfWidth )+ halfWidth, -(vertexA.getY() * halfHeight) + halfHeight),
                new Vector((vertexB.getX() * halfWidth) + halfWidth, -(vertexB.getY() * halfHeight) + halfHeight),
                new Vector((vertexC.getX() * halfWidth) + halfWidth, -(vertexC.getY() * halfHeight) + halfHeight)
        );
    }

    public double getMinX() {
        double min = vertexA.getX();
        for (Vector p : vertexes) {
            if (p.getX() < min) min = p.getX();
        }
        return min;
    }

    public double getMaxX() {
        double max = vertexA.getX();
        for (Vector p : vertexes) {
            if (p.getX() > max) max = p.getX();
        }
        return max;
    }

    public double getMinY() {
        double min = vertexA.getY();
        for (Vector p : vertexes) {
            if (p.getY() < min) min = p.getY();
        }
        return min;
    }

    public double getMaxY() {
        double max = vertexA.getY();
        for (Vector p : vertexes) {
            if (p.getY() > max) max = p.getY();
        }
        return max;
    }

}
