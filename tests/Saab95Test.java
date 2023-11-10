import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Car;
import src.Saab95;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class Saab95Test {
    Car currentCar;
    Car currentCar2;

    @BeforeEach
    public void createSaab(){
        currentCar = new Saab95();
        currentCar2 = new Saab95();
    }

    @Test
    public void engineShouldStartAt0Point1(){
        currentCar.startEngine();
        assertEquals(currentCar.getCurrentSpeed(), 0.1);
    }
    @Test
    public void getColorShouldGetSettedColor(){
        currentCar.setColor(Color.green);
        assertEquals(currentCar.getColor(), Color.green);
    }
    @Test
    public void carXShouldInitAtZero(){
        assertEquals(currentCar.getX(), 0, 0.0001);
    }
    @Test
    public void carYShouldInitAtZero(){
        assertEquals(currentCar.getY(), 0, 0.0001);
    }

    @Test
    public void carShouldNotMoveAtInit(){
        assertEquals(0, currentCar.getCurrentSpeed());
    }

    @Test
    public void carShouldMoveToTheLeftAt90DegLeftTurn(){
        currentCar.turnLeft(90);
        currentCar.move();
        assertEquals(currentCar.getX(), -currentCar.getCurrentSpeed(), 0.0001);
    }
    @Test
    public void carShouldMoveNorthEastAt45DegRightTurn(){
        currentCar.turnRight(45);
        currentCar.move();
        assertEquals(currentCar.getX(), currentCar.getCurrentSpeed()*Math.sqrt(2), 0.0001);
    }
    @Test
    public void carShouldIncreaseSpeedIfGas(){
        currentCar.gas(0.5);
        assertTrue(0 < currentCar.getCurrentSpeed());
    }

    @Test
    public void carShouldNotBrakeMoreThanOne() throws IllegalArgumentException{
        assertThrows(IllegalArgumentException.class, () -> currentCar.brake(2));
    }
}