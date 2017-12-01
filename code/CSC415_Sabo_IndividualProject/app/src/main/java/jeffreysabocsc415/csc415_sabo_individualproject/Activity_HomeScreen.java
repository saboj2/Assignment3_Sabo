// Name: Jeffrey Sabo
// Course: CSC 415
// Semester: Fall 2017
// Instructor: Dr. Pulimood
// Project name: Individual Project
// Description: Gender-Neutral Bathroom Locator for TCNJ
// Filename: Activity_HomeScreen.java
// Description: This is the activity that launches when the app launches. It creates a UI layout
// and contains functionality for button presses
// Last modified on: 12/1/2017

package jeffreysabocsc415.csc415_sabo_individualproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class Activity_HomeScreen extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView mAboutParagraph;
    private Button mAboutButton;
    private Button mSearchButton;
    private Button mInfoButton;
    private Spinner mLocationSpinner;
    private TextView mFoundBathroom1;
    private TextView mFoundBathroom2;


    public Map tcnj;

    //-----------------------------------------------------------------------------------------
//
//  Function: onCreate ()
//
//    Parameters:
//    input Bundle saveInstanceState; state of instance before switching activities
//
//
//    Pre-condition: activity must be launched from app launch of back button
//    Post-condition: Creates UI and repsonds to user inputs
//-----------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //Create map object from JSON file
        try
        {
            tcnj = new Map(new JSONObject(loadJSONFromAsset()));
        } catch (JSONException e)
        {
            e.printStackTrace();
        }

        mFoundBathroom1 = (TextView) findViewById(R.id.foundBathroomName1);
        mFoundBathroom2 = (TextView) findViewById(R.id.foundBathroomName2);

        //Button listener to start About page
        mAboutButton = (Button) findViewById(R.id.about_button);
        mAboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchActivity();
            }
        });
        //Button listener to start a search
        mSearchButton = (Button) findViewById(R.id.search_button);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLocationSpinner = (Spinner) findViewById(R.id.spinner1);
                String starting_location = mLocationSpinner.getSelectedItem().toString();
                Vertex found_bathrooms = find_bathroom(starting_location);
                mFoundBathroom1.setText(found_bathrooms.get_name());
                //mFoundBathroom2.setText(found_bathrooms[1].get_name());
            }
        });
        //Button listener to start info page
        mInfoButton = (Button) findViewById(R.id.info_button);
        mInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLocationSpinner = (Spinner) findViewById(R.id.spinner1);
                String bathroom_name = mLocationSpinner.getSelectedItem().toString();
                Vertex temp = tcnj.find_vertex(bathroom_name);
                if(temp.get_isbathroom()) {
                    Intent i = new Intent(Activity_HomeScreen.this, Activity_BathroomInfoScreen.class);

                    i.putExtra(Activity_BathroomInfoScreen.EXTRA_BATHROOM_NAME, temp.get_isbathroom());
                    i.putExtra(Activity_BathroomInfoScreen.EXTRA_FLOOR, temp.get_bathroom().get_floor());
                    startActivity(i);
                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),"Not a Bathroom!", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
    }


    private void launchActivity() {

        Intent intent = new Intent(this, Activity_AboutScreen.class);
        startActivity(intent);
    }

    //-----------------------------------------------------------------------------------------
//
//  Function: find_bathroom ()
//
//    Parameters:
//    input String starting_location: name of chosen starting location
//
//
//    Pre-condition: User chooses to find nearest GN bathroom from a starting_location
//    Post-condition: calls Map function to start Dijkstra's algorithm
//-----------------------------------------------------------------------------------------
    private Vertex find_bathroom( String starting_location)
    {
        return tcnj.closest_bathroom(starting_location);
    }

    //-----------------------------------------------------------------------------------------
//
//  Function: loadJSONFromAsset ()
//
//    Parameters:
//    none
//
//
//    Pre-condition: new Map object must be created from JSON file
//    Post-condition: opens JSON file and sends it back to Map object constructor
//-----------------------------------------------------------------------------------------
    public String loadJSONFromAsset() throws JSONException
    {
        String json = null;
        try
        {
            InputStream is = getAssets().open("tcnj.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
