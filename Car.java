import java.awt.*;
public abstract class Car implements Movable {

    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double[] currentPosition;
    protected double currentRotation;

    public Car(int nrDoors, Color color, double enginePower, String modelName){
        nrDoors = nrDoors;
        color = color;
        enginePower = enginePower;
        modelName = modelName;
        stopEngine();
        resetTransform();
    }

    public void move(){
        x = currentPosition[0];
        y = currentPosition[1];

    }

    public void turnLeft(double degrees){
        currentRotation += degrees;
        currentRotation = (rotation % 360) - 180;
    }
    public void turnRight(double degrees){
        currentRotation -= degrees;
        currentRotation = (rotation % 360) - 180;
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        color = color;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    private double speedFactor(){
        return enginePower * 0.01;
    }

    public void resetTransform(){
        currentPosition = {0,0};
        currentRotation = 0;
    }
    private void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    private void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

}
