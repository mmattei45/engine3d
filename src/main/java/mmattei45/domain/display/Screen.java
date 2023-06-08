package mmattei45.domain.display;

public interface Screen {

    void init();
    void setLine(int y, String s);
    void exit();
    char getChar();
    int getHeight();
    int getWidth();
    void clear();
    void refresh();

}
