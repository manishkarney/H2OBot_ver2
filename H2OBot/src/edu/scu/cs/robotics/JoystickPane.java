package edu.scu.cs.robotics;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import edu.scu.cs.robotics.customviews.JoystickView;
import edu.scu.cs.robotics.customviews.JoystickView.OnJoystickMoveListener;

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
		
		
		// Adding two joysticks
		leftJoystick = new JoystickView(mActivity, null);
	
		leftJoystick.setOnJoystickMoveListener(new OnJoystickMoveListener() {

			@Override
			public void onValueChanged(int angle, int power, int direction) {
				// TODO Auto-generated method stub
				System.out.println("LEFT JOYSTICK | Angle: "
						+ String.valueOf(angle) + "°");
				System.out.println("LEFT JOYSTICK | Power:"
						+ String.valueOf(power) + "%");
				switch (direction) {
				case JoystickView.FRONT:
					System.out.println("LEFT JOYSTICK | Dir: "
							+ JoystickView.FRONT);
					break;
				case JoystickView.FRONT_RIGHT:
					System.out.println("LEFT JOYSTICK | Dir: "
							+ JoystickView.FRONT_RIGHT);
					break;
				case JoystickView.RIGHT:
					System.out.println("LEFT JOYSTICK | Dir: "
							+ JoystickView.RIGHT);
					break;
				case JoystickView.RIGHT_BOTTOM:
					System.out.println("LEFT JOYSTICK | Dir: "
							+ JoystickView.RIGHT_BOTTOM);
					break;
				case JoystickView.BOTTOM:
					System.out.println("LEFT JOYSTICK | Dir: "
							+ JoystickView.BOTTOM);
					break;
				case JoystickView.BOTTOM_LEFT:
					System.out.println("LEFT JOYSTICK | Dir: "
							+ JoystickView.BOTTOM_LEFT);
					break;
				case JoystickView.LEFT:
					System.out.println("LEFT JOYSTICK | Dir: "
							+ JoystickView.LEFT);
					break;
				case JoystickView.LEFT_FRONT:
					System.out.println("LEFT JOYSTICK | Dir: "
							+ JoystickView.LEFT_FRONT);
					break;
				default:
					System.out.println("LEFT JOYSTICK | Dir: "
							+ JoystickView.FRONT);
				}
			}
		}, JoystickView.DEFAULT_LOOP_INTERVAL);
	
	
	
	rightJoystick = new JoystickView(mActivity, null);
	
	rightJoystick.setOnJoystickMoveListener(new OnJoystickMoveListener() {

		@Override
		public void onValueChanged(int angle, int power, int direction) {
			// TODO Auto-generated method stub
			System.out.println("RIGHT JOYSTICK | Angle: "
					+ String.valueOf(angle) + "°");
			System.out.println("RIGHT JOYSTICK | Power:"
					+ String.valueOf(power) + "%");
			switch (direction) {
			case JoystickView.FRONT:
				System.out.println("RIGHT JOYSTICK | Dir: "
						+ JoystickView.FRONT);
				break;
			case JoystickView.FRONT_RIGHT:
				System.out.println("RIGHT JOYSTICK | Dir: "
						+ JoystickView.FRONT_RIGHT);
				break;
			case JoystickView.RIGHT:
				System.out.println("RIGHT JOYSTICK | Dir: "
						+ JoystickView.RIGHT);
				break;
			case JoystickView.RIGHT_BOTTOM:
				System.out.println("RIGHT JOYSTICK | Dir: "
						+ JoystickView.RIGHT_BOTTOM);
				break;
			case JoystickView.BOTTOM:
				System.out.println("RIGHT JOYSTICK | Dir: "
						+ JoystickView.BOTTOM);
				break;
			case JoystickView.BOTTOM_LEFT:
				System.out.println("RIGHT JOYSTICK | Dir: "
						+ JoystickView.BOTTOM_LEFT);
				break;
			case JoystickView.LEFT:
				System.out.println("RIGHT JOYSTICK | Dir: "
						+ JoystickView.LEFT);
				break;
			case JoystickView.LEFT_FRONT:
				System.out.println("RIGHT JOYSTICK | Dir: "
						+ JoystickView.LEFT_FRONT);
				break;
			default:
				System.out.println("RIGHT JOYSTICK | Dir: "
						+ JoystickView.FRONT);
			}
		}
	}, JoystickView.DEFAULT_LOOP_INTERVAL);
	
	
	
	leftJoystickContainer.addView(leftJoystick);
	rightJoystickContainer.addView(rightJoystick);
	
	
	RelativeLayout.LayoutParams leftLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT );
	leftLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
	

	
	
}

}
