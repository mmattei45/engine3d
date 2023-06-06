package mmattei45.domain.display;

import mmattei45.domain.model.Face;

public class Rasterizer {

    private Buffer buffer;

    public Rasterizer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void rasterize(Face face) {
        var sTriangle = face.getToScreenCords(buffer.getWidth(), buffer.getHeight());

        int minX = Math.max(0, (int) sTriangle.getMinX() + 1);
        int maxX = Math.min(buffer.getWidth(), (int) sTriangle.getMaxX() + 1);
        int minY = Math.max(0, (int) sTriangle.getMinY());
        int maxY = Math.min(buffer.getHeight(), (int) sTriangle.getMaxY() + 1);

        for (int y = minY; y < maxY; y++) {
            for (int x = minX; x < maxX; x++) {
                if (sTriangle.containsPoint(x, y))
                    buffer.setValue(x, y, 'X');
            }
        }
    }

}
