package mmattei45.domain.display;

import mmattei45.domain.Utils;

import java.util.HashMap;

public class Buffer {

    Screen Screen;
    char[][] colorBuffer;
    Double[][] depthBuffer;

    public Buffer(Screen Screen) {
        this.Screen = Screen;
        resetBuffer();
    }

    public void setValue(int x, int y, char val, double depth) {
        Double currDepth = depthBuffer[y][x];

        if (currDepth == null || depth < currDepth) {
                colorBuffer[y][x] = val;
        }
    }

    public void resetBuffer() {
        colorBuffer = new char[Screen.getHeight()][Screen.getWidth()];
        depthBuffer = new Double[Screen.getHeight()][Screen.getWidth()];

        for (var arr : colorBuffer) Utils.fillArray(arr, ' ');
        for (var arr : depthBuffer) Utils.fillArray(arr, null);
    }

    public void presentFrame() {
        for (int i = 0; i < colorBuffer.length; i++) {
            Screen.setLine(i, new String(colorBuffer[i]));
        }
    }

    public int getWidth() {
        return Screen.getWidth();
    }

    public int getHeight() {
        return Screen.getHeight();
    }

}
