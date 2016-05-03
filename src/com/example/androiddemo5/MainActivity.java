package com.example.androiddemo5;

import java.util.ArrayList;
import java.util.List;

import android.R.color;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private GridView gridView;
	private List<Integer> list;
	private Context mContext;
	private boolean isFirst = true;
	private int lastSelectPostison = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = this;
		lastSelectPostison = PreferenceManager.getDefaultSharedPreferences(
				mContext).getInt("lastSelectPostison", 0);
		gridView = (GridView) findViewById(R.id.gridView);
		init();
		MyAdapter adapter = new MyAdapter();
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				PreferenceManager.getDefaultSharedPreferences(mContext).edit()
						.putInt("lastSelectPostison", position).commit();
				if (isFirst) {
					parent.getChildAt(lastSelectPostison)
							.findViewById(R.id.imageView)
							.setBackgroundColor(color.white);
					isFirst = false;
				}
			}
		});

	}

	private void init() {
		// TODO Auto-generated method stub
		list = new ArrayList<Integer>();
		list.add(R.drawable.xinjinghuatuijian);
		list.add(R.drawable.xinkachedaquan);
		list.add(R.drawable.xinpeijianshangcheng);
		list.add(R.drawable.xinpeijianshangcheng);
		list.add(R.drawable.xinwenzhangzixun);
		list.add(R.drawable.xinwodetiezi);
		list.add(R.drawable.xinwoyaofatie);
		list.add(R.drawable.xinyijianfankui);
		list.add(R.drawable.xinzuixintiezi);
	}

	private class MyAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(final int position, View convertView,
				final ViewGroup parent) {
			// TODO Auto-generated method stub
			if (convertView == null) {
				convertView = LayoutInflater.from(MainActivity.this).inflate(
						R.layout.activity_amin_item, null);
			}
			ImageView img = (ImageView) convertView
					.findViewById(R.id.imageView);
			img.setImageResource(list.get(position));
			if (isFirst) {
				if (lastSelectPostison == position) {
					img.setBackgroundColor(mContext.getResources().getColor(
							R.color.font_gray));
				}
			}
			img.setOnTouchListener(new OnTouchListener() {

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					if (event.getAction() == MotionEvent.ACTION_DOWN) {
						System.out.println("ACTION_DOWN");

					}
					return false;
				}
			});
			return convertView;
		}

	}

}
