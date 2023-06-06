package mmattei45.domain.model;

import mmattei45.domain.math.Vector;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private List<Vector> vertexes = new ArrayList<>();
    private List<Vector> normals = new ArrayList<>();
    private List<Face> faces = new ArrayList<>();

    public void addVertex(Vector vertex) {
        vertexes.add(vertex);
    }

    public void addNormal(Vector normal) {
        normals.add(normal);
    }

    public void addFace(Face face) {
        faces.add(face);
    }

//    public void transform(Matrix44 t) {
//        for (int i = 0; i < vertexes.size(); i++) {
//            vertexes.get(i).transform(t);
//        }
//    }

    public Vector getVertex(int idx) {
        return vertexes.get(idx);
    }

    public Vector getNormal(int idx) {
        return normals.get(idx);
    }

    public Face getFace(int idx) {
        return faces.get(idx);
    }

    public List<Vector> getVertexes() {
        return vertexes;
    }

    public List<Vector> getNormals() {
        return normals;
    }

    public List<Face> getFaces() {
        return faces;
    }
    
}
