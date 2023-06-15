package mmattei45.domain.display;

import mmattei45.domain.math.Vector;
import mmattei45.domain.model.Face;

import java.util.HashMap;

public class SimpleLight {

    private static final HashMap<Integer, Character> charMap = initializeCharMap();
    private static final double MAX_ANGLE = 180;

    private Vector direction;

    public SimpleLight(double x, double y, double z) {
        this.direction = new Vector(x, y, z);
    }

    public char calculateOutputChar(Face face) {
        var normal = face.getNormal();
        var angle = this.direction.angle(normal);
        var charCode = (int) (angle / MAX_ANGLE * 10);
        return charMap.get(charCode);
    }

    private static HashMap<Integer, Character> initializeCharMap() {
        var charMap = new HashMap<Integer, Character>();

        charMap.put(10, '$');
        charMap.put(9, '8');
        charMap.put(8, '&');
        charMap.put(7, '*');
        charMap.put(6, 'd');
        charMap.put(5, 'Q');
        charMap.put(4, 'X');
        charMap.put(3, 'x');
        charMap.put(2, '|');
        charMap.put(1, '?');
        charMap.put(0, '.');

        return charMap;
    }

}
