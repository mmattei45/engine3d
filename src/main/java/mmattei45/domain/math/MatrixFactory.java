package mmattei45.domain.math;

import org.ejml.simple.SimpleMatrix;

public class MatrixFactory {

    public static SimpleMatrix rotation(double xAngle, double yAngle, double zAngle) {
        var matrix = SimpleMatrix.identity(4);
        var xRotation = xRotationMatrix(Math.toRadians(xAngle));
        var yRotation = yRotationMatrix(Math.toRadians(yAngle));
        var zRotation = zRotationMatrix(Math.toRadians(zAngle));

        return matrix.mult(xRotation).mult(yRotation).mult(zRotation);
    }

    private static SimpleMatrix xRotationMatrix(double xAngle) {
        var matrix = SimpleMatrix.identity(4);
        var sin = Math.sin(xAngle);
        var cos = Math.cos(xAngle);

        matrix.setRow(0, 0, 1, 0, 0, 0);
        matrix.setRow(1, 0, 0, cos, -sin, 0);
        matrix.setRow(2, 0, 0, sin, cos, 0);
        matrix.setRow(3, 0, 0, 0, 0, 1);

        return matrix;
    }

    private static SimpleMatrix yRotationMatrix(double yAngle) {
        var matrix = SimpleMatrix.identity(4);
        var sin = Math.sin(yAngle);
        var cos = Math.cos(yAngle);

        matrix.setRow(0, 0, cos, 0, sin, 0);
        matrix.setRow(1, 0, 0, 1, 0, 0);
        matrix.setRow(2, 0, -sin, 0, cos, 0);
        matrix.setRow(3, 0, 0, 0, 0, 1);

        return matrix;
    }

    private static SimpleMatrix zRotationMatrix(double zAngle) {
        var matrix = SimpleMatrix.identity(4);
        var sin = Math.sin(zAngle);
        var cos = Math.cos(zAngle);

        matrix.setRow(0, 0, cos, -sin, 0, 0);
        matrix.setRow(1, 0, sin, cos, 0, 0);
        matrix.setRow(2, 0, 0, 0, 1, 0);
        matrix.setRow(3, 0, 0, 0, 0, 1);

        return matrix;
    }


}
