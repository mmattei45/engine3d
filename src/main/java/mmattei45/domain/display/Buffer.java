package mmattei45.domain.display;

import mmattei45.domain.Utils;

public class Buffer {

    Screen Screen;
    char[][] buffer;

    public Buffer(Screen Screen) {
        this.Screen = Screen;
        resetBuffer();
    }

    public void setValue(int x, int y, char val) {
        buffer[y][x] = val;
    }

    public void resetBuffer() {
        buffer = new char[Screen.getHeight()][Screen.getWidth()];
        for (char[] arr : buffer) Utils.fillArray(arr, ' ');
    }

    public void presentFrame() {
        for (int i = 0; i < buffer.length; i++) {
            Screen.setLine(i, new String(buffer[i]));
        }
    }

    public int getWidth() {
        return Screen.getWidth();
    }

    public int getHeight() {
        return Screen.getHeight();
    }


}
