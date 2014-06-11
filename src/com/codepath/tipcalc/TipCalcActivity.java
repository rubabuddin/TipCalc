package com.codepath.tipcalc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.math.BigDecimal;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalcActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public String readTotal(){
		String text_amount = "0";
    	EditText etEnterAmount = (EditText) findViewById(R.id.etEnterAmount);
    	text_amount = etEnterAmount.getText().toString();
    	Log.e("read text_amount", text_amount);
    	System.out.println("read_text_amount" + text_amount);
    	if(text_amount.equals(""))
    		return null;
    	return text_amount;
    }
	private TextView TipAmountOutput;
	
	public void tipCalc(View v)
	{
		TipAmountOutput = (TextView) findViewById(R.id.tvTipAmount);
		BigDecimal tip_amount = new BigDecimal(0.0); //the total tip amount to presented at end
		BigDecimal amount;
		BigDecimal percentage;
		
		String tipPercentage = (String) v.getTag();//percentage chosen by user
				
		String billTotal = readTotal();//the bill total as read from the EditText
				
		try{
			amount = new BigDecimal(billTotal);
		} catch (Exception e){	
			amount = null;
	    }
		
		try{
			percentage = new BigDecimal(tipPercentage);
		} catch (Exception e){
			percentage = null;
		}
		
		String tipAmount;
		if(billTotal != null){	
			tip_amount = amount.multiply(percentage);
			tipAmount = tip_amount.toString();
		}
		else
			tipAmount = "0";

		TipAmountOutput.setText("$"+tipAmount);
	}

};