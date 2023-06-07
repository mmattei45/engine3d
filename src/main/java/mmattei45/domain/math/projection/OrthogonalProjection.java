package mmattei45.domain.math.projection;

import org.ejml.simple.SimpleMatrix;

public class OrthogonalProjection {

    public static SimpleMatrix getMatrix(double bottom, double top, double near, double far, double left, double right) {
        var scale = getScaleMatrix(bottom, top, near, far, left, right);
        var move = getTranslationMatrix(bottom, top, near, far, left, right);
        return scale.mult(move);
    }

    private static SimpleMatrix getScaleMatrix(double bottom, double top, double near, double far, double left, double right) {
        var matrix = SimpleMatrix.identity(4);
        matrix.setRow(0, 0, 2 / (right - left), 0, 0, 0);
        matrix.setRow(1, 0, 0, 2 / (top - bottom), 0, 0);
        matrix.setRow(2, 0, 0, 0, 2 / (far - near), 0);
        matrix.setRow(3, 0, 0, 0, 0, 1);
        return matrix;
    }

    private static SimpleMatrix getTranslationMatrix(double bottom, double top, double near, double far, double left, double right) {
        var matrix = SimpleMatrix.identity(4);
        matrix.setRow(0, 0, 1, 0, 0, - (left + right) / 2);
        matrix.setRow(1, 0, 0, 1, 0, - (top + bottom) / 2);
        matrix.setRow(2, 0, 0, 0, 1, - (near + far) / 2);
        matrix.setRow(3, 0, 0, 0, 0, 1);
        return matrix;
    }

}
