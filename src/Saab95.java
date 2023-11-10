package src;

import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95(){
        super(2, Color.red, 125, "Saab95");
        setTurboOff();
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    protected double speedFactor(){
        double turbo = 1;
        double turboFactor = 1.3;
        if(turboOn) turbo = turboFactor;
        return getEnginePower() * 0.01 * turbo;
    }

}
