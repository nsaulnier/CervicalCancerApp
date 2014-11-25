package edu.smu.cervicalcancerapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;


public class NewPatient extends Activity {

    Button createNewPatient;
    EditText enterFirstName;
    EditText enterLastName;
    DatePicker enterDOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_patient);

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
                //create a new intent and bundle to pass to PatientInfo
                Intent i = new Intent(v.getContext(), PatientInfo.class);
                //i.putExtra("userName", userName.getText().toString());
                //i.putExtra("passWord", passWord.getText().toString());
                //i.putExtra("office", selectOffice.getItemAtPosition(selectOffice.getSelectedItemPosition()).toString());
                startActivity(i);
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
