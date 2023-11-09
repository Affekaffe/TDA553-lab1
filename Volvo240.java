import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;
    
    public Volvo240(){
        super(4, Color.black, 100, "Volvo240");
    }

    @Override
    public void turnLeft(double degrees) {
        super.turnLeft(degrees);
    }

    @Override
    public void turnRight(double degrees) {
        super.turnRight(degrees);
    }

    @Override
    protected double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}
