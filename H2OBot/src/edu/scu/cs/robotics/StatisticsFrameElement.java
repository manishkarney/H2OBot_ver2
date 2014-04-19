package edu.scu.cs.robotics;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StatisticsFrameElement {

	String elementName = null;
	// InnerElements
	TextView nameTextView = null;
	TextView valueTextView = null;
	RelativeLayout statisticsElement=null;

	public StatisticsFrameElement(Context context,ViewGroup parent, String elementName) {
		this.initComponent(context,parent);
		this.elementName = elementName;
	}

	

	private void initComponent(Context context,ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.element_statistics_frame, parent,
				false);
		statisticsElement=(RelativeLayout)v.findViewById(R.id.statistics_element_relative_layout);
		parent.addView(statisticsElement);
		nameTextView = (TextView) statisticsElement
				.findViewById(R.id.statistics_element_name);
		valueTextView = (TextView) statisticsElement
				.findViewById(R.id.statistics_element_value);
		
		nameTextView.setText(elementName);
	}

	TextView getNameTextView() {
		return nameTextView;
	}

	TextView getValueTextView() {
		return valueTextView;
	}

	public void setName(String name) {
		nameTextView.setText(name);
	}

	public void setValue(String value) {
		valueTextView.setText(value);
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}



	public RelativeLayout getStatisticsElement() {
		return statisticsElement;
	}

	public void setStatisticsElement(RelativeLayout statisticsElement) {
		this.statisticsElement = statisticsElement;
	}
	
	

}
