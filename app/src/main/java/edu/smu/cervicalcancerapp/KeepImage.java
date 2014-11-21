package edu.smu.cervicalcancerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class KeepImage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keep_image);

        // setup buttons
        Button keepImage = (Button) findViewById(R.id.yes);
        Button discardImage = (Button) findViewById(R.id.no);

        //set the keepImage onClickListener
        View.OnClickListener keepImageHandler = new View.OnClickListener() {
            public void onClick(View v) {
                //create a new intent and bundle to pass to TakeAnotherImage
                Intent i = new Intent(v.getContext(), TakeAnotherImage.class);
                //i.putExtra("userName", userName.getText().toString());
                //i.putExtra("passWord", passWord.getText().toString());
                //i.putExtra("office", selectOffice.getItemAtPosition(selectOffice.getSelectedItemPosition()).toString());
                startActivity(i);
            }

        };
        keepImage.setOnClickListener(keepImageHandler);

        //set the discardImage onClickListener
        View.OnClickListener discardImageHandler = new View.OnClickListener() {
            public void onClick(View v) {
                //create a new intent and bundle to pass to TakeAnotherImage
                Intent i = new Intent(v.getContext(), TakeAnotherImage.class);
                //i.putExtra("userName", userName.getText().toString());
                //i.putExtra("passWord", passWord.getText().toString());
                //i.putExtra("office", selectOffice.getItemAtPosition(selectOffice.getSelectedItemPosition()).toString());
                startActivity(i);
            }

        };
        discardImage.setOnClickListener(discardImageHandler);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_keep_image, menu);
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
