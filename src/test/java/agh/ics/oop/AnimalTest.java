package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    void constructorTest() {
        Vector2d initialPosition = new Vector2d(2, 2);
        Animal animal = new Animal(initialPosition);
        assertEquals(initialPosition, animal.getPosition());
        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    void defaultConstructorTest() {
        Animal animal = new Animal();
        assertEquals(new Vector2d(2, 2), animal.getPosition());
        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    void moveForwardTest() {
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 3), animal.getPosition());
        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    void moveBackwardTest() {
        Animal animal = new Animal();
        animal.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(2, 1), animal.getPosition());
        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    void turnRightTest() {
        Animal animal = new Animal();
        animal.move(MoveDirection.RIGHT);
        assertEquals(new Vector2d(2, 2), animal.getPosition());
        assertEquals(MapDirection.EAST, animal.getOrientation());
    }

    @Test
    void turnLeftTest() {
        Animal animal = new Animal();
        animal.move(MoveDirection.LEFT);
        assertEquals(new Vector2d(2, 2), animal.getPosition());
        assertEquals(MapDirection.WEST, animal.getOrientation());
    }

    @Test
    void moveBeyondBoundariesTest() {
        Animal animal = new Animal(new Vector2d(4, 4));
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(4, 4), animal.getPosition());
    }

    @Test
    void moveBackwardBeyondBoundariesTest() {
        Animal animal = new Animal(new Vector2d(0, 0));
        animal.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(0, 0), animal.getPosition());
    }
}
