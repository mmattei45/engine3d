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
