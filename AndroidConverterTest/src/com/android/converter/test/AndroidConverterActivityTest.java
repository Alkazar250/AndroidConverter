package com.android.converter.test;

import android.test.ActivityInstrumentationTestCase2;
import java.util.ArrayList;
import com.jayway.android.robotium.solo.Solo;
import com.android.converter.AndroidConverterActivity;
import android.view.View;
import android.widget.EditText;

public class AndroidConverterActivityTest extends
		ActivityInstrumentationTestCase2<AndroidConverterActivity> {

	private static final int ACTIVITY_WAIT_MILLIS = 500;
	private Solo solo;

	public AndroidConverterActivityTest() {
		super("com.android.converter", AndroidConverterActivity.class);
	}

	@Override
	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	@Override
	public void tearDown() throws Exception {
		try {
			solo.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		getActivity().finish();
		super.tearDown();
	}

	public void testRecordedTest() throws Exception {

		// Entered Activity "AndroidConverter" com.android.converter.AndroidConverterActivity
		solo.waitForActivity("com.android.converter.AndroidConverterActivity", ACTIVITY_WAIT_MILLIS);
  	  	solo.clearEditText((EditText)findViewById(com.android.converter.R.id.editKmPerHour));
		solo.clickOnView(findViewById(com.android.converter.R.id.editKmPerHour));
		solo.enterText(
						(EditText) findViewById(com.android.converter.R.id.editKmPerHour),
						"1");
		solo.clickOnView(findViewById(com.android.converter.R.id.ConvToMs));
		          
		solo.clickOnView(findViewById(com.android.converter.R.id.editMetersPerSec));
		
		assertTrue(solo.searchEditText("0.2777777777777778"));  
		
  	  	solo.clearEditText((EditText)findViewById(com.android.converter.R.id.editKmPerHour));
		solo.clickOnView(findViewById(com.android.converter.R.id.editKmPerHour));
		solo.enterText(
						(EditText) findViewById(com.android.converter.R.id.editKmPerHour),
						"10");
		solo.clickOnView(findViewById(com.android.converter.R.id.ConvToMs));
		          
		solo.clickOnView(findViewById(com.android.converter.R.id.editMetersPerSec));
		
		assertTrue(solo.searchEditText("2.777777777777777"));  
		
	}

	/**
	 * Enhanced view finder. First tries to find it from Activity, then from all Views under ViewRoot.
	 */
	public View findViewById(int id) {
		View view = solo.getView(id);
		if (view != null)
			return view;

		ArrayList<View> views = solo.getViews();
		for (View v : views) {
			if (v.getId() == id) {
				return v;
			}
		}
		return null;
	}

}
