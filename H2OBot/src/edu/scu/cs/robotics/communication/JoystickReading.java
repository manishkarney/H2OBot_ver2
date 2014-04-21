package edu.scu.cs.robotics.communication;

/**
 * A wrapper class to hold Direction, Power and Angle values form the soft Joystick
 * Created by manishkarney on 4/20/14.
 */
public class JoystickReading {
    private short angle = 0;
    private short power = 0;
    private short direction = 0;

    public JoystickReading(int angle, int power, int direction) {
        this.angle = (short) angle;
        this.power = (short) power;
        this.direction = (short) direction;
    }

    public JoystickReading(){

    }
    public synchronized void setValues(int angle, int power, int direction) {
        this.angle = (short) angle;
        this.power = (short) power;
        this.direction = (short) direction;
    }

    public synchronized short getAngle() {
        return angle;
    }

    public synchronized void setAngle(short angle) {
        this.angle = angle;
    }

    public synchronized short getPower() {
        return power;
    }

    public synchronized void setPower(short power) {
        this.power = power;
    }

    public synchronized short getDirection() {
        return direction;
    }

    public synchronized void setDirection(short direction) {
        this.direction = direction;
    }

}