package mmattei45.infra.jna;

import com.sun.jna.Library;

public interface NCurses extends Library {

    public void curs_set(int state);
    public void endwin();
    public void erase();
    public char getch();
    public void initscr();
    public void mvprintw(int y, int x, char c);
    public void mvaddstr(int y, int x, String str);
    public void noecho();
    public void refresh();

}
