package edu.smu.cervicalcancerapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class StartScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        // declare buttons
        Button newPatient = (Button) findViewById(R.id.new_patient);
        Button currentPatient = (Button) findViewById(R.id.current_patient);
        Button closeApp = (Button) findViewById(R.id.close_app);

        //set the newPatient onClickListener
        View.OnClickListener newPatientHandler = new View.OnClickListener() {
            public void onClick(View v) {
                //create a new intent and bundle to pass to NewPatient
                Intent i = new Intent(v.getContext(), NewPatient.class);
                startActivity(i);
            }

        };
        newPatient.setOnClickListener(newPatientHandler);

        //set the currentPatient onClickListener
        View.OnClickListener currentPatientHandler = new View.OnClickListener() {
            public void onClick(View v) {
                //create a new intent and bundle to pass to NewPatient
                Intent i = new Intent(v.getContext(), SelectCurrentPatient.class);
                startActivity(i);
            }

        };
        currentPatient.setOnClickListener(currentPatientHandler);

        //set the closeApp onClickListener
        View.OnClickListener closeAppHandler = new View.OnClickListener() {
            public void onClick(View v) {
                // note that this does not actually kill the process, it simply returns the user to the home screen

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                //android.os.Process.killProcess(android.os.Process.myPid());
                //System.exit(1);

                //finish();
            }

        };
        closeApp.setOnClickListener(closeAppHandler);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_screen, menu);
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
