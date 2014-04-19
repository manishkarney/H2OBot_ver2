package edu.scu.cs.robotics;

import java.util.HashMap;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class StatisticsPaneManager {

	private H2OBotStartActivity mActivity = null;
	private FrameLayout mStatsPane = null;
	private HorizontalScrollView mScrollView = null;
	private LinearLayout mLinearLayout = null;
	private HashMap<String, StatisticsFrameElement> mStatistics = new HashMap<String, StatisticsFrameElement>();

	// View for displaying statistics
	String STATISTICS_NAMES[] = { "Temparature", "Depth", "Voltage",
			"JoyStick1", "JoyStick2", "JoyStick3" };

	public StatisticsPaneManager(H2OBotStartActivity activity) {
		mActivity = activity;
		init();
	}

	private void init() {
		mStatsPane = (FrameLayout) mActivity.findViewById(R.id.stats_pane);
		mScrollView = (HorizontalScrollView) mActivity
				.findViewById(R.id.stats_scroll_view);
		mLinearLayout = (LinearLayout) mActivity
				.findViewById(R.id.stats_content_view);

		// adding statistics elements

		for (String name : STATISTICS_NAMES) {
			StatisticsFrameElement element = new StatisticsFrameElement(
					mActivity, mLinearLayout, name);
			element.setName(name);
			mStatistics.put(name, element);
		}
	}

	void addStatisticsElement(StatisticsFrameElement element) {
		mLinearLayout.addView(element.getStatisticsElement());
	}

	boolean removeStatisticsElement(StatisticsFrameElement element) {
		boolean isChild = (element.getStatisticsElement().getParent() == mLinearLayout);
		mLinearLayout.removeView(element.getStatisticsElement());
		return isChild;
	}

	HashMap<String, StatisticsFrameElement> getAllStatisticsElements() {
		return mStatistics;
	}

}
