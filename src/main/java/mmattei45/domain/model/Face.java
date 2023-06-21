package mmattei45.domain.model;


import mmattei45.domain.math.Vector;
import org.ejml.simple.SimpleMatrix;

public class Face {

    private Vector[] vertexes = new Vector[3];
    private Vector vertexA;
    private Vector vertexB;
    private Vector vertexC;
    private Vector normal;

    public Face(Vector vertexA, Vector vertexB, Vector vertexC, Vector normal) {
        this.normal = normal;
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

        normal.transform(matrix);
    }

    public Face getTransformed(SimpleMatrix matrix) {
        var vector0 = vertexA.getTransformed(matrix);
        var vector1 = vertexB.getTransformed(matrix);
        var vector2 = vertexC.getTransformed(matrix);
        var tNormal = normal.getTransformed(matrix);

        return new Face(vector0, vector1, vector2, tNormal);
    }

    public double getAproximateDepth(Vector baricentricCoords) {
        return vertexA.getZ() * baricentricCoords.getX() +
                vertexB.getZ() * baricentricCoords.getY() +
                vertexC.getZ() * baricentricCoords.getZ();
    }

    public Vector getBaricentricCoordinates(double x, double y) {
        double barX = ((vertexB.getY() - vertexC.getY()) * (x - vertexC.getX()) +
                (vertexC.getX() - vertexB.getX()) * (y - vertexC.getY())) /
                ((vertexB.getY() - vertexC.getY()) * (vertexA.getX() - vertexC.getX()) +
                        (vertexC.getX() - vertexB.getX()) * (vertexA.getY() - vertexC.getY()));

        double barY = ((vertexC.getY() - vertexA.getY()) * (x - vertexC.getX()) +
                (vertexA.getX() - vertexC.getX()) * (y - vertexC.getY())) /
                ((vertexB.getY() - vertexC.getY()) * (vertexA.getX() - vertexC.getX()) +
                        (vertexC.getX() - vertexB.getX()) * (vertexA.getY() - vertexC.getY()));

        double barZ = 1.0 - barX - barY;

        return new Vector(barX, barY, barZ);
    }

    public boolean containsPoint(Vector baricentricCoords) {
        var one = baricentricCoords.getX() < -0.01;
        var two = baricentricCoords.getY() < -0.01;
        var three = baricentricCoords.getZ() < -0.01;

        return ((one == two) && (two == three));
    }

    public Face getToScreenCords(int width, int height) {
        int halfWidth = width / 2;
        int halfHeight = height / 2;

        return new Face(
                new Vector((vertexA.getX() * halfWidth )+ halfWidth, -(vertexA.getY() * halfHeight) + halfHeight),
                new Vector((vertexB.getX() * halfWidth) + halfWidth, -(vertexB.getY() * halfHeight) + halfHeight),
                new Vector((vertexC.getX() * halfWidth) + halfWidth, -(vertexC.getY() * halfHeight) + halfHeight),
                new Vector(normal.getX(), normal.getY(), normal.getZ())
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

    public Vector getNormal() {
        return normal;
    }

}
