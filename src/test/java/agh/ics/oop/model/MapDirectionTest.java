package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MapDirectionTest {
    @Test
    void next() {
        assertEquals(MapDirection.EAST, MapDirection.next(MapDirection.NORTH));
        assertEquals(MapDirection.SOUTH, MapDirection.next(MapDirection.EAST));
        assertEquals(MapDirection.WEST, MapDirection.next(MapDirection.SOUTH));
        assertEquals(MapDirection.NORTH, MapDirection.next(MapDirection.WEST));
    }

    @Test
    void previous() {
        assertEquals(MapDirection.EAST, MapDirection.previous(MapDirection.SOUTH));
        assertEquals(MapDirection.NORTH, MapDirection.previous(MapDirection.EAST));
        assertEquals(MapDirection.WEST, MapDirection.previous(MapDirection.NORTH));
        assertEquals(MapDirection.SOUTH, MapDirection.previous(MapDirection.WEST));
    }
    @Test
    void toUnitVector() {
        assertEquals(new Vector2d(0, -1), MapDirection.toUnitVector(MapDirection.SOUTH));
        assertEquals(new Vector2d(1, 0), MapDirection.toUnitVector(MapDirection.EAST));
        assertEquals(new Vector2d(0, 1), MapDirection.toUnitVector(MapDirection.NORTH));
        assertEquals(new Vector2d(-1, 0), MapDirection.toUnitVector(MapDirection.WEST));
    }
    @Test
    void toStringTest() {
        assertEquals("Południe", MapDirection.toString(MapDirection.SOUTH));
        assertEquals("Wschód", MapDirection.toString(MapDirection.EAST));
        assertEquals("Północ", MapDirection.toString(MapDirection.NORTH));
        assertEquals("Zachód", MapDirection.toString(MapDirection.WEST));
    }
}
