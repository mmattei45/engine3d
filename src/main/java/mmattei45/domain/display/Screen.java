package mmattei45.domain.display;

public interface Screen {

    void init();
    void setLine(int y, String s);
    void exit();
    char getChar();
    public int getHeight();
    public int getWidth();

}
