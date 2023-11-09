import java.awt.*;
public abstract class Car implements Movable {

    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private double[] currentPosition;
    private double currentRotation;

    public Car(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
        resetTransform();
    }

    public void move(){
        currentPosition[0] += getCurrentSpeed() * Math.sin(Math.toRadians(getCurrentRotation()));
        currentPosition[1] += getCurrentSpeed() * Math.cos(Math.toRadians(getCurrentRotation()));
    }

    public double getCurrentRotation() {
        return currentRotation;
    }

    public double getX() {
        return currentPosition[0];
    }

    public double getY(){
        return currentPosition[1];
    }

    public void turnLeft(double degrees){
        currentRotation -= degrees;
        currentRotation = (currentRotation % 360) - 180;
    }
    public void turnRight(double degrees){
        currentRotation += degrees;
        currentRotation = (currentRotation % 360) - 180;
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
    public String getModelName(){
        return modelName;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    protected double speedFactor(){
        return getEnginePower() * 0.01;
    }

    public void resetTransform(){
        currentPosition = new double[]{0,0};
        currentRotation = 0;
    }
    private void incrementSpeed(double amount){
        double newSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
        if(newSpeed > currentSpeed) currentSpeed = newSpeed;
    }

    private void decrementSpeed(double amount){
        double newSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        if(newSpeed < currentSpeed) currentSpeed = newSpeed;
    }
    public void gas(double amount) throws IllegalArgumentException {
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Gas amount must be double in range [0,1]");
        }
        incrementSpeed(amount);
    }

    public void brake(double amount) throws IllegalArgumentException {
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Gas amount must be double in range [0,1]");
        }
        decrementSpeed(amount);
    }
}
