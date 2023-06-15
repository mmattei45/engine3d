package mmattei45.domain.display;

import mmattei45.domain.math.Vector;
import mmattei45.domain.model.Face;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class SimpleLightTest {

    @Mock private Face face;
    private SimpleLight sot = new SimpleLight(0, 1, 0);

    @Test
    public void biggestAngleTest() {
        Mockito.when(face.getNormal()).thenReturn(new Vector(0, 1, 0));
        char c = sot.calculateOutputChar(face);
        assertEquals('.', c);
    }

    @Test
    public void lowestAngleTest() {
        Mockito.when(face.getNormal()).thenReturn(new Vector(0, -1, 0));
        char c = sot.calculateOutputChar(face);
        assertEquals('$', c);
    }

    @Test
    public void halfAngleTest() {
        Mockito.when(face.getNormal()).thenReturn(new Vector(1, 0, 0));
        char c = sot.calculateOutputChar(face);
        assertEquals('Q', c);
    }

}