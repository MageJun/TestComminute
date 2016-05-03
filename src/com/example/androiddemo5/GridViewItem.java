package com.example.androiddemo5;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class GridViewItem extends LinearLayout {

	public GridViewItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		setMeasuredDimension(getDefaultSize(0, widthMeasureSpec),
				getDefaultSize(0, heightMeasureSpec));
		int childeWidth = getMeasuredWidth();
		int childeHeight = getMeasuredHeight();
		childeHeight = childeWidth = MeasureSpec.makeMeasureSpec(childeWidth,
				MeasureSpec.EXACTLY);
		super.onMeasure(childeWidth, childeHeight);
		
	}

}
