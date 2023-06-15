package mmattei45.domain;

public class Utils {

    public static void fillArray(char[] array, char value) {
        int len = array.length;
        if (len > 0) array[0] = value;

        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, ((len - i) < i) ? (len - i) : i);
        }
    }

    public static void fillArray(Object[] array, Object value) {
        int len = array.length;
        if (len > 0) array[0] = value;

        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, ((len - i) < i) ? (len - i) : i);
        }
    }

}
