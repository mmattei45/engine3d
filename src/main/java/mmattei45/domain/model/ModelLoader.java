package mmattei45.domain.model;

import mmattei45.domain.math.Vector;

import java.io.InputStream;
import java.util.Scanner;

public class ModelLoader {

    public static Model loadModel(String filePath) {
        return teste(filePath);
    }

    private static Model teste(String filePath) {
        var file = getFileReader(filePath);
        var model = loadModel(file);
        file.close();
        return model;
    }

    private static Scanner getFileReader(String filePath) {
        InputStream file = ClassLoader.getSystemClassLoader().getResourceAsStream(filePath);
        return new Scanner(file);
    }

    private static  Model loadModel(Scanner file) {
        var model = new Model();

        while (file.hasNextLine()) {
            String line = file.nextLine();
            String linePrefix = line.split("\\ +")[0];

            switch (linePrefix) {
                case "v":
                    model.addVertex(extractVector(line)); break;
                case "vn":
                    model.addNormal(extractVector(line)); break;
                case "f":
                    model.addFace(extractFace(line, model)); break;
            }
        }

        return model;
    }

    private static Vector extractVector(String line) {
        String[] split = line.split("\\ +");
        return new Vector(Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3]), 1);
    }

    private static Face extractFace(String line, Model model) {
        var split = line.split("\\ +");

        var vector0 = extractFaceVector(split[1], model);
        var vector1 = extractFaceVector(split[2], model);
        var vector2 = extractFaceVector(split[3], model);

        return new Face(vector0, vector1, vector2);
    }

    private static Vector extractFaceVector(String info, Model model) {
        var split = info.split("/");
        int vectorIdx = Integer.parseInt(split[0]) - 1;

        return model.getVertex(vectorIdx);
    }

}
