package mmattei45.domain.math;

import org.ejml.simple.SimpleMatrix;

public class Vector {

    private SimpleMatrix matrix;

    public Vector(double x, double y) {
        this(x, y, 0, 0);
    }

    public Vector(double x, double y, double z) {
        this(x, y, z, 0);
    }

    public Vector(double x, double y, double z, double w) {
        var matrix = new SimpleMatrix(4, 1);
        matrix.setRow(0, 0, x);
        matrix.setRow(1, 0, y);
        matrix.setRow(2, 0, z);
        matrix.setRow(3, 0, w);
        this.matrix = matrix;
    }

    public Vector(SimpleMatrix matrix) {
        this.matrix = matrix;
    }

    public Vector crossProduct(Vector vector) {
        var crossX = (getY() * vector.getZ()) - (getZ() * vector.getY());
        var crossY = (getZ() * vector.getX()) - (getX() * vector.getZ());
        var crossZ = (getX() * vector.getY()) - (getY() * vector.getX());

        return new Vector(crossX, crossY, crossZ);
    }

    public double dotProduct(Vector vector) {
        return (getX() * vector.getX()) +
                (getY() * vector.getY()) +
                (getZ() * vector.getZ()) +
                (getW() * vector.getW());
    }

    public double magnitude() {
        var squareSums = (getX() * getX()) + (getY() * getY()) + (getZ() * getZ()) + (getW() * getW());
        return Math.sqrt(squareSums);
    }

    public double angle(Vector vector) {
        var dotProduct = dotProduct(vector);
        var magnitudeSum = magnitude() * vector.magnitude();

        return Math.toDegrees(Math.acos(dotProduct / magnitudeSum));
    }

    public double getX() {
        return matrix.get(0, 0);
    };

    public double getY() {
        return matrix.get(1, 0);
    };

    public double getZ() {
        return matrix.get(2, 0);
    };

    public double getW() {
        return matrix.get(3, 0);
    };


    public void transform(SimpleMatrix transformationMatrix) {
        this.matrix = transformationMatrix.mult(matrix);
    }

    public Vector getTransformed(SimpleMatrix transformationMatrix) {
        return new Vector(transformationMatrix.mult(matrix));
    }

}
