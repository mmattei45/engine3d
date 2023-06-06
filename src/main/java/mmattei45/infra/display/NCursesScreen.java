package mmattei45.infra.display;

import com.sun.jna.Native;
import mmattei45.domain.display.Screen;
import mmattei45.infra.jna.NCurses;

public class NCursesScreen implements Screen {

    private static final NCurses NCURSES = Native.load("ncurses", NCurses.class);

    @Override
    public void init() {
        NCURSES.initscr();
        NCURSES.noecho();
        NCURSES.curs_set(0);
    }

    @Override
    public void setLine(int y, String s) {
        NCURSES.mvaddstr(y, 0, s);
    }

    @Override
    public void exit() {
        NCURSES.endwin();
    }

    @Override
    public char getChar() {
        return NCURSES.getch();
    }

    @Override
    public int getHeight() {
        return 50;
    }

    @Override
    public int getWidth() {
        return 200;
    }

}
