package edu.smu.cervicalcancerapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


public class NewPatient extends Activity {

    Button createNewPatient;
    EditText enterFirstName;
    EditText enterLastName;
    DatePicker enterDOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_patient);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.hide();

        createNewPatient = (Button) findViewById(R.id.create_new_patient);
        enterFirstName = (EditText) findViewById(R.id.enter_first_name);
        enterLastName = (EditText) findViewById(R.id.enter_family_name);
        enterDOB = (DatePicker) findViewById(R.id.enter_dob);

        // come back to this: is there a way to make the keyboard go away when they tap outside?
        //InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //inputManager.hideSoftInputFromWindow(enterFirstName.getWindowToken(),0);
        //inputManager.hideSoftInputFromWindow(enterLastName.getWindowToken(),0);

        //set the createNewPatient onClickListener
        View.OnClickListener createNewPatientHandler = new View.OnClickListener() {
            public void onClick(View v) {

                if (enterFirstName.getText().toString().trim().length() == 0) {
                    //tell user to enter a first Name
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter a first name.";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.setGravity(Gravity.TOP,0,100);
                    toast.show();

                }
                else if (enterLastName.getText().toString().trim().length() == 0) {
                    //tell user to enter a last name
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter a family name.";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.setGravity(Gravity.TOP,0,100);
                    toast.show();
                }
                else {
                    // extract patient info
                    String firstName = enterFirstName.getText().toString();
                    String lastName = enterLastName.getText().toString();

                    // get date of birth in format YYYYMMDD
                    String day = "";
                    String month = "";
                    if (Integer.toString(enterDOB.getDayOfMonth()).trim().length() == 1){
                        day = "0" + Integer.toString(enterDOB.getDayOfMonth());
                    }
                    else{
                        day = Integer.toString(enterDOB.getDayOfMonth());
                    }
                    if(Integer.toString(enterDOB.getMonth() + 1).trim().length() == 1){
                        month = "0"+Integer.toString(enterDOB.getMonth() + 1);
                    }
                    else{
                        month = Integer.toString(enterDOB.getMonth() + 1);
                    }
                    String year = Integer.toString(enterDOB.getYear());
                    String dob = year + month + day;

                    //test code
                    //Log.d("newpatient", firstName);
                    //Log.d("newpatient", lastName);
                    //Log.d("newpatient", firstName);
                    //Log.d("newpatient", dob);

                    //Rebecca insert code here
                    // create a new SQLite entry for patient


                    // open new activity
                    Intent i = new Intent(v.getContext(), PatientInfo.class);
                    i.putExtra("firstName", firstName);
                    i.putExtra("lastName", lastName);
                    i.putExtra("dob", dob);
                    startActivity(i);
                }
            }

        };
        createNewPatient.setOnClickListener(createNewPatientHandler);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_patient, menu);
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
