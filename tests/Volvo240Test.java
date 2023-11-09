import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Volvo240Test {

    Car currentCar;
    @BeforeEach
    public void createVolvo(){
        currentCar = new Volvo240();
    }

    @Test
    public void modelNameIsVolvo240(){
        assertEquals(currentCar.getModelName(), "Volvo240");
    }
    @Test
    public void carShouldMoveToTheLeftAt90DegLeftTurn(){
        currentCar.turnLeft(90);
        currentCar.move();
        assertEquals(currentCar.getX(), -currentCar.getCurrentSpeed(), 0.0001);
    }
    @Test
    public void volvoShouldHaveFourDoors(){
        assertEquals(currentCar.getNrDoors(), 4);
    }
}