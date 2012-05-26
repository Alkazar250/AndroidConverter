package com.android.converter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;

public class AndroidConverterActivity extends Activity {
	final String LOG = "SpeedConverter";
	final String errorMsg ="Error during convertion";
    private EditText editKmPerHour;
    private EditText editMeterPerSec;
    private Button ConvToMs;
    private Button ConvToKmh;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);


            editKmPerHour = (EditText) findViewById(R.id.editKmPerHour);
            editMeterPerSec = (EditText) findViewById(R.id.editMetersPerSec);
            ConvToMs = (Button) findViewById(R.id.ConvToMs);
            ConvToKmh = (Button) findViewById(R.id.ConvToKmh);

            ConvToMs.setOnClickListener( new OnClickListener(){
            	@Override
				public void onClick(View arg0) {
            		try {
                        double kmPerHour = Double.parseDouble(editKmPerHour.getText().toString());
                        double meterPerSec = kmPerHour * 0.2777777777777778;
                        editMeterPerSec.setText(new Double(meterPerSec).toString());
	                } catch (NumberFormatException e) {
	                        editMeterPerSec.setText(errorMsg);
	                        Log.d(LOG, "e:" + e);
	                }
				}
            });
            
            ConvToKmh.setOnClickListener( new OnClickListener(){
            	@Override
				public void onClick(View arg0) {
            		try {
                        double meterPerSec = Double.parseDouble(editMeterPerSec.getText().toString());
                        double kmPerHour = meterPerSec * 3.6;
                        editKmPerHour.setText(new Double(kmPerHour).toString());
            		} catch (NumberFormatException e) {
                        editKmPerHour.setText(errorMsg);
                        Log.d(LOG, "e:" + e);
            		}
				}
            });
            
            // setup listener for Kilometers per hour EditText
            editKmPerHour.setOnKeyListener(new OnKeyListener() {
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                            if (event.getAction() == KeyEvent.ACTION_UP) {
                                    try {
                                            double kmPerHour = Double.parseDouble(editKmPerHour.getText().toString());
                                            double meterPerSec = kmPerHour * 0.2777777777777778;
                                            editMeterPerSec.setText(new Double(meterPerSec).toString());
                                    } catch (NumberFormatException e) {
                                            editMeterPerSec.setText(errorMsg);
                                            Log.d(LOG, "e:" + e);
                                    }
                                    return true;
                            }
                            return false;
                    }
            });


            // setup listener for Meters per second EditText
            editMeterPerSec.setOnKeyListener(new OnKeyListener() {
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                            if (event.getAction() == KeyEvent.ACTION_UP) {
                                    try {
                                            double meterPerSec = Double.parseDouble(editMeterPerSec.getText().toString());
                                            double kmPerHour = meterPerSec * 3.6;
                                            editKmPerHour.setText(new Double(kmPerHour).toString());
                                    } catch (NumberFormatException e) {
                                            editKmPerHour.setText(errorMsg);
                                            Log.d(LOG, "e:" + e);
                                    }
                                    return true;
                            } 
                            return false;
                    }
            });
    }
}