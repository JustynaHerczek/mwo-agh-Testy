package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationIntegrationTest {

    @Test
    void multipleAnimalsCollisionTest() {
        // Test sprawdzający kolizje między zwierzętami w symulacji
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(2, 3), new Vector2d(2, 4));
        List<MoveDirection> directions = List.of(MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD);

        Simulation simulation = new Simulation(positions, directions);
        simulation.run();

        List<Animal> animals = simulation.getAnimalList();

        // Oczekujemy, że zwierzęta na pozycji 2, 3 i 4 kolidują ze sobą
        assertEquals(new Vector2d(2, 3), animals.get(0).getPosition());
        assertEquals(new Vector2d(2, 4), animals.get(1).getPosition());
        assertEquals(new Vector2d(2, 4), animals.get(2).getPosition());
    }

    @Test
    void multipleAnimalsBoundaryTest() {
        // Test sprawdzający, czy zwierzęta nie wychodzą poza granice planszy
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 3), new Vector2d(4, 4));
        List<MoveDirection> directions = List.of(MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD);

        Simulation simulation = new Simulation(positions, directions);
        simulation.run();

        List<Animal> animals = simulation.getAnimalList();

        // Oczekujemy, że zwierzęta na pozycji 2, 3 i 4 nie wychodzą poza granice planszy
        assertEquals(new Vector2d(2, 3), animals.get(0).getPosition());
        assertEquals(new Vector2d(3, 3), animals.get(1).getPosition());
        assertEquals(new Vector2d(4, 4), animals.get(2).getPosition());
    }


}

