// Name: Jeffrey Sabo
// Course: CSC 415
// Semester: Fall 2017
// Instructor: Dr. Pulimood
// Project name: Individual Project
// Description: Gender-Neutral Bathroom Locator for TCNJ
// Filename: Activity_BathroomInfoScreen.java
// Description: This activity is started to display information about a specific bathroom
// Last modified on: 12/1/2017
package jeffreysabocsc415.csc415_sabo_individualproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_BathroomInfoScreen extends Activity {

    public static final String EXTRA_BATHROOM_NAME = "bathroom_name";
    public static final String EXTRA_FLOOR = "floor";
    private String mBathroomName;
    private String mFloor;
    private TextView mBathroom_Title;
    private TextView mBathroom_Floor;
    //-----------------------------------------------------------------------------------------
//
//  Function: onCreate ()
//
//    Parameters:
//    input Bundle saveInstanceState; state of instance before switching activities
//
//
//    Pre-condition: activity must be launched from info button press
//    Post-condition: Creates UI and repsonds to user inputs
//-----------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bathroom_info);

        mBathroomName = getIntent().getStringExtra(EXTRA_BATHROOM_NAME);
        mFloor = getIntent().getStringExtra(EXTRA_FLOOR);

        //Concatenate strings to display to screen
        mBathroom_Title = (TextView) findViewById(R.id.bathroom_name);
        mBathroom_Floor = (TextView) findViewById(R.id.bathroom_floor);
        String message1 = "This bathroom is located in " + mBathroomName +".";
        String message2 = "This bathroom will be found on the " + mBathroom_Floor + " floor.";
        mBathroom_Title.setText(message1);
        mBathroom_Floor.setText(message2);
    }

}
