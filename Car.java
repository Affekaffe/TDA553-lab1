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
        currentRotation += degrees;
        currentRotation = (currentRotation % 360) - 180;
    }
    public void turnRight(double degrees){
        currentRotation -= degrees;
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

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    protected double speedFactor(){
        return enginePower * 0.01;
    }

    public void resetTransform(){
        currentPosition = new double[]{0,0};
        currentRotation = 0;
    }
    protected void incrementSpeed(double amount){
        double newSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        if(newSpeed > currentSpeed) currentSpeed = newSpeed;
    }

    protected void decrementSpeed(double amount){
        double newSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        if(newSpeed < currentSpeed) currentSpeed = newSpeed;
    }
    public void gas(double amount) throws Exception {
        if(amount < 0 || amount > 1){
            throw new Exception("Gas amount must be in range [0,1]");
        }
        incrementSpeed(amount);
    }

    public void brake(double amount) throws Exception {
        if(amount < 0 || amount > 1){
            throw new Exception("Brake amount must be in range [0,1]");
        }
        decrementSpeed(amount);
    }

}
