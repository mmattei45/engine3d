package mmattei45.domain.math.projection;

import org.ejml.simple.SimpleMatrix;

public class PerspectiveProjection {

    public static SimpleMatrix getMatrix(double fov, double aspect, double zNear, double zFar) {
        SimpleMatrix projMatrix = SimpleMatrix.identity(4);
        double tanhfov = Math.tan(fov / 2);

        projMatrix.set(0, 0, 1/(aspect * tanhfov));
        projMatrix.set(1, 1, 1/tanhfov);
        projMatrix.set(2, 2, -(zNear + zFar) / (zFar - zNear));
        projMatrix.set(2, 3, -1);
        projMatrix.set(3, 2, -(2 * zFar * zNear) / (zFar - zNear));

        return projMatrix;
    }

}
