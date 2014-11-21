package edu.smu.cervicalcancerapp;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;


//public class PatientInfo extends Activity {
public class PatientInfo extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);

        // setup the tabs
        TabHost th = (TabHost) findViewById(android.R.id.tabhost);
        th.setup();

        TabHost.TabSpec ts = th.newTabSpec("Patient Info");
        ts.setContent(R.id.tab1);
        ts.setIndicator("Patient Info");
        th.addTab(ts);

        TabHost.TabSpec ts2 = th.newTabSpec("Patient Images");
        ts2.setContent(R.id.tab2);
        ts2.setIndicator("Patient Images");
        th.addTab(ts2);

        // set up the buttons
        Button takeAnImage1 = (Button) findViewById(R.id.take_an_image1);
        Button takeAnImage2 = (Button) findViewById(R.id.take_an_image2);


        //set the takeAnImage onClickListener
        View.OnClickListener takeAnImageHandler = new View.OnClickListener() {
            public void onClick(View v) {
                //create a new intent and bundle to pass to PatientInfo
                Intent i = new Intent(v.getContext(), TakeImage.class);
                //i.putExtra("userName", userName.getText().toString());
                //i.putExtra("passWord", passWord.getText().toString());
                //i.putExtra("office", selectOffice.getItemAtPosition(selectOffice.getSelectedItemPosition()).toString());
                startActivity(i);
            }
        };
        takeAnImage1.setOnClickListener(takeAnImageHandler);
        takeAnImage2.setOnClickListener(takeAnImageHandler);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_patient_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
