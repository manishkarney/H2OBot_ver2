package edu.scu.cs.robotics;

import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import edu.scu.cs.robotics.customviews.JoystickView;
import edu.scu.cs.robotics.customviews.JoystickView.OnJoystickMoveListener;
import edu.scu.cs.robotics.communication.JoystickReading;
import edu.scu.cs.robotics.communication.JoysticksInput;

public class JoystickPane {

	private H2OBotStartActivity mActivity = null;
	private RelativeLayout mJoystickContentPane = null;
	private JoystickView leftJoystick = null;
	private JoystickView rightJoystick = null;
	private FrameLayout leftJoystickContainer=null;
	private FrameLayout rightJoystickContainer=null;
	

	public JoystickPane(H2OBotStartActivity activity) {
		mActivity = activity;
		init();
	}

	private void init() {
		mJoystickContentPane = (RelativeLayout) mActivity
				.findViewById(R.id.joystick_pane);

		leftJoystickContainer =(FrameLayout) mActivity
				.findViewById(R.id.left_joystick_container); 
		rightJoystickContainer =(FrameLayout) mActivity
				.findViewById(R.id.right_joystick_container);

        final JoysticksInput inputReadings = JoysticksInput.getInstance();

		//Hooking the readings objects
        final JoystickReading leftJoystickReading = inputReadings.getLeftJoystick();
        final JoystickReading rightJoystickReading = inputReadings.getRightJoystick();

		// Adding two joysticks
		leftJoystick = new JoystickView(mActivity, null);
	
		leftJoystick.setOnJoystickMoveListener(new OnJoystickMoveListener() {

			@Override
			public void onValueChanged(int angle, int power, int direction) {
				// Capturing Left Joystick

                leftJoystickReading.setValues(angle,power,direction);
				switch (direction) {
				case JoystickView.FRONT:
					break;
				case JoystickView.FRONT_RIGHT:

					break;
				case JoystickView.RIGHT:

					break;
				case JoystickView.RIGHT_BOTTOM:

					break;
				case JoystickView.BOTTOM:

					break;
				case JoystickView.BOTTOM_LEFT:

					break;
				case JoystickView.LEFT:

					break;
				case JoystickView.LEFT_FRONT:

					break;
				default:

				}
			}
		}, JoystickView.DEFAULT_LOOP_INTERVAL);
	
	
	
	rightJoystick = new JoystickView(mActivity, null);
	
	rightJoystick.setOnJoystickMoveListener(new OnJoystickMoveListener() {

        @Override
        public void onValueChanged(int angle, int power, int direction) {
            // Capturing Left Joystick

            rightJoystickReading.setValues(angle, power, direction);
            switch (direction) {
                case JoystickView.FRONT:
                    break;
                case JoystickView.FRONT_RIGHT:

                    break;
                case JoystickView.RIGHT:

                    break;
                case JoystickView.RIGHT_BOTTOM:

                    break;
                case JoystickView.BOTTOM:

                    break;
                case JoystickView.BOTTOM_LEFT:

                    break;
                case JoystickView.LEFT:

                    break;
                case JoystickView.LEFT_FRONT:

                    break;
                default:

            }
        }
    }, JoystickView.DEFAULT_LOOP_INTERVAL);
	


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Readings " + inputReadings.getReadingsData());
                }
            }
        }).start();

	
	leftJoystickContainer.addView(leftJoystick);
	rightJoystickContainer.addView(rightJoystick);
	
//
//	RelativeLayout.LayoutParams leftLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT );
//	leftLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//

	
	
}

}
