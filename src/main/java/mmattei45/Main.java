package mmattei45;

import mmattei45.domain.display.Buffer;
import mmattei45.domain.display.Rasterizer;
import mmattei45.domain.display.Screen;
import mmattei45.domain.math.MatrixFactory;
import mmattei45.domain.math.Vector;
import mmattei45.domain.model.Face;
import mmattei45.domain.model.ModelLoader;
import mmattei45.infra.display.NCursesScreen;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var screen = new NCursesScreen();
        var buffer = new Buffer(screen);
        var rasterizer = new Rasterizer(buffer);
        var rotation = MatrixFactory.rotation(0, 15, -10);
        var model = ModelLoader.loadModel("teapot.obj");
        var faces = model.getFaces();

        screen.init();

        for (int i = 0; i < 100; i++) {
            screen.clear();
            buffer.resetBuffer();
            rasterizeFaces(rasterizer, faces);
            model.transform(rotation);
            buffer.presentFrame();
            screen.refresh();
            Thread.sleep(70);
        }

        screen.exit();
    }

    private static void rasterizeFaces(Rasterizer rasterizer, List<Face> faces) {
        for (int i = 0; i < faces.size(); i++) {
            rasterizer.rasterize(faces.get(i));
        }
    }

}
