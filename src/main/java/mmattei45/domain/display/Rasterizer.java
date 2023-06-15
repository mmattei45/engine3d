package mmattei45.domain.display;

import mmattei45.domain.math.Vector;
import mmattei45.domain.math.projection.OrthogonalProjection;
import mmattei45.domain.math.projection.PerspectiveProjection;
import mmattei45.domain.model.Face;
import org.ejml.simple.SimpleMatrix;

import java.util.HashMap;

public class Rasterizer {

    private Buffer buffer;
    private SimpleLight light = new SimpleLight(1, 1, -1);
    private SimpleMatrix projection = PerspectiveProjection.getMatrix(1.6d, (200 / 2) / 50, 0.2d, 400);
//    private SimpleMatrix projection = OrthogonalProjection.getMatrix(-1, 1, -1, 1, -2, 2);;

    public Rasterizer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void rasterize(Face face) {
        var tFace = face.getTransformed(projection);
        var sTriangle = tFace.getToScreenCords(buffer.getWidth(), buffer.getHeight());
        var color = light.calculateOutputChar(tFace);
        var depth = 1;

        int minX = Math.max(0, (int) sTriangle.getMinX() + 1);
        int maxX = Math.min(buffer.getWidth(), (int) sTriangle.getMaxX() + 1);
        int minY = Math.max(0, (int) sTriangle.getMinY());
        int maxY = Math.min(buffer.getHeight(), (int) sTriangle.getMaxY() + 1);

        for (int y = minY; y < maxY; y++) {
            for (int x = minX; x < maxX; x++) {
                if (sTriangle.containsPoint(x, y))
                    buffer.setValue(x, y, color, depth);
            }
        }
    }

}
