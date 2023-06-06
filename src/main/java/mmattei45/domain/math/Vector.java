package mmattei45.domain.math;

import org.ejml.simple.SimpleMatrix;

public class Vector {

    public double x, y, z, w;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
        this.z = 0;
        this.w = 1;
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = 1;
    }

    public Vector(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public void transform(SimpleMatrix matrix) {
        transform(matrix, this, this);
    }

    private static Vector transform(SimpleMatrix matrix, Vector vector, Vector dest) {
        double x = matrix.get(0, 0) * vector.x + matrix.get(1, 0) * vector.y + matrix.get(2, 0) * vector.z + matrix.get(3, 0) * vector.w;
        double y = matrix.get(0, 1) * vector.x + matrix.get(1, 1) * vector.y + matrix.get(2, 1) * vector.z + matrix.get(3, 1) * vector.w;
        double z = matrix.get(0, 2) * vector.x + matrix.get(1, 2) * vector.y + matrix.get(2, 2) * vector.z + matrix.get(3, 2) * vector.w;
        double w = matrix.get(0, 3) * vector.x + matrix.get(1, 3) * vector.y + matrix.get(2, 3) * vector.z + matrix.get(3, 3) * vector.w;

        dest.x = x;
        dest.y = y;
        dest.z = z;
        dest.w = w;

        return dest;
    }

}
