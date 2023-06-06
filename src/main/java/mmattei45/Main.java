package mmattei45;

import mmattei45.domain.display.Buffer;
import mmattei45.domain.display.Rasterizer;
import mmattei45.domain.math.MatrixFactory;
import mmattei45.domain.math.Vector;
import mmattei45.domain.math.projection.OrthogonalProjection;
import mmattei45.domain.model.Face;
import mmattei45.infra.display.NCursesScreen;
import org.ejml.simple.SimpleMatrix;

public class Main {
    public static void main(String[] args) {
        var screen = new NCursesScreen();
        var buffer = new Buffer(screen);
        var rasterizer = new Rasterizer(buffer);





        var rotation = MatrixFactory.rotation(0, 0, 90);
        var triangle = get2dTriange();



        
        triangle.transform(rotation);

        screen.init();


        rasterizer.rasterize(triangle);
        buffer.presentFrame();

        screen.getChar();
        screen.exit();
    }

    private static Face get2dTriange() {
        return new Face(
                new Vector(0, -0.5, 0, 1),
                new Vector(-0.5, 0.5, 0, 1),
                new Vector(0.5, 0.5, 0, 1)
        );
    }

    private static SimpleMatrix getProjection() {
        return OrthogonalProjection.getMatrix(-1, 1, -1, 1, -2, 2);
//        return PerspectiveProjetction.getMatrix(1.6d, (Terminal.WIDTH / 2) / Terminal.HEIGHT, 0.2d, 400);
    }
}