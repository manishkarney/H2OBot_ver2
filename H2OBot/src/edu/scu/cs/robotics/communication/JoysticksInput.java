package edu.scu.cs.robotics.communication;

/**
 * Singleton that maintains joystick inputs. This is used to obtain string representation of current Joystick inputs.
 * Created by manishkarney on 4/20/14.
 */
public class JoysticksInput {

    private static JoysticksInput instance=null;
    private  JoystickReading leftJoystickReadings=null;



    private  JoystickReading rightJoystickReadings=null;
    private  StringBuilder mStringBuilder=null;

    //Constants
    private static final char[] messageHead = {'{','[','l','#'};
    private static final char[] messageMid = {']','%','[','r','#'};
    private static final char[] messageEnd = {']','}'};
    private static final char comma = ',';
    private static final char[] directionId = {'d',':'};
    private static final char[] angleId = {'a',':'};
    private static final char[] powerId = {'p',':'};

    private JoysticksInput(){
        leftJoystickReadings = new JoystickReading(0,0,0);
        rightJoystickReadings = new JoystickReading(0,0,0);
    }

    public static synchronized JoysticksInput getInstance(){
        if(instance==null){
            instance = new JoysticksInput();
        }
       return instance;
    }

    public synchronized String getReadingsData(){
        if(mStringBuilder==null) {
            mStringBuilder = new StringBuilder();
        }
    //forming the string
        char[] directionValue;
        char[] angleValue;
        char[] powerValue;

        //Left Joystick
        directionValue = (""+leftJoystickReadings.getDirection()).toCharArray();
        angleValue = (""+leftJoystickReadings.getAngle()).toCharArray();
        powerValue = (""+leftJoystickReadings.getPower()).toCharArray();

        mStringBuilder.append(messageHead);
        mStringBuilder.append(directionId);
        mStringBuilder.append(directionValue);
        mStringBuilder.append(comma);
        mStringBuilder.append(angleId);
        mStringBuilder.append(angleValue);
        mStringBuilder.append(comma);
        mStringBuilder.append(powerId);
        mStringBuilder.append(powerValue);
        mStringBuilder.append(messageMid);

        directionValue = (""+rightJoystickReadings.getDirection()).toCharArray();
        angleValue = (""+rightJoystickReadings.getAngle()).toCharArray();
        powerValue = (""+rightJoystickReadings.getPower()).toCharArray();

        mStringBuilder.append(directionId);
        mStringBuilder.append(directionValue);
        mStringBuilder.append(comma);
        mStringBuilder.append(angleId);
        mStringBuilder.append(angleValue);
        mStringBuilder.append(comma);
        mStringBuilder.append(powerId);
        mStringBuilder.append(powerValue);
        mStringBuilder.append(messageEnd);

        String data = mStringBuilder.toString();
        mStringBuilder.setLength(0);
        return data;
    }



    public synchronized JoystickReading getRightJoystick() {
        return rightJoystickReadings;
    }

    public synchronized JoystickReading getLeftJoystick() {
        return leftJoystickReadings;
    }

}
