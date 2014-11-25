package edu.smu.cervicalcancerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class SelectCurrentPatient extends Activity {

    Button selectPatient;
    Button sortByFirstName;
    Button sortByLastName;
    Button sortByDOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_current_patient);

        selectPatient = (Button) findViewById(R.id.select_patient);
        sortByDOB = (Button) findViewById(R.id.sort_by_dob);
        sortByFirstName = (Button) findViewById(R.id.sort_by_first_name);
        sortByLastName = (Button) findViewById(R.id.sort_by_last_name);

        //Rebecca insert code here
        // setup spinner


        //set the sortByDOB onClickListener
        View.OnClickListener sortByDOBHandler = new View.OnClickListener() {
            public void onClick(View v) {
                //Rebecca insert code here
                // resort spinner entries by DOB
            }

        };
        sortByDOB.setOnClickListener(sortByDOBHandler);

        //set the sortByFirstName onClickListener
        View.OnClickListener sortByFirstNameHandler = new View.OnClickListener() {
            public void onClick(View v) {
                //Rebecca insert code here
                // resort spinner entries by first name
            }

        };
        sortByFirstName.setOnClickListener(sortByFirstNameHandler);

        //set the sortByLastName onClickListener
        View.OnClickListener sortByLastNameHandler = new View.OnClickListener() {
            public void onClick(View v) {
                //Rebecca insert code here
                // resort spinner entries by last name
            }

        };
        sortByLastName.setOnClickListener(sortByLastNameHandler);

        //set the createNewPatient onClickListener
        View.OnClickListener selectPatientHandler = new View.OnClickListener() {
            public void onClick(View v) {
                //create a new intent and bundle to pass to PatientInfo
                Intent i = new Intent(v.getContext(), PatientInfo.class);

                String firstName = "";
                String lastName = "";
                String dob = "";
                //Rebecca insert code here
                // retrieve SQLite patient firstName, lastName, dob (date of birth)

                //test code
                //Log.d("currentpatient", firstName);
                //Log.d("currentpatient", lastName);
                //Log.d("currentpatient", firstName);
                //Log.d("currentpatient", dob);

                i.putExtra("firstName", firstName);
                i.putExtra("lastName", lastName);
                i.putExtra("dob", dob);
                startActivity(i);
            }

        };
        selectPatient.setOnClickListener(selectPatientHandler);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_current_patient, menu);
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
