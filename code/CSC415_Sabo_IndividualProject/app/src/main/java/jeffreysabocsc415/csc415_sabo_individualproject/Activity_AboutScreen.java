// Name: Jeffrey Sabo
// Course: CSC 415
// Semester: Fall 2017
// Instructor: Dr. Pulimood
// Project name: Individual Project
// Description: Gender-Neutral Bathroom Locator for TCNJ
// Filename: Activity_AboutScreen.java
// Description: This activity is started to display information about the app itself
// Last modified on: 12/1/2017
package jeffreysabocsc415.csc415_sabo_individualproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_AboutScreen extends Activity {

    private Button mBackButton;
    //-----------------------------------------------------------------------------------------
//
//  Function: onCreate ()
//
//    Parameters:
//    input Bundle saveInstanceState; state of instance before switching activities
//
//
//    Pre-condition: activity must be launched from about button press
//    Post-condition: Creates UI and repsonds to user inputs
//-----------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);

        //Button listener to go back to home page
        mBackButton = (Button) findViewById(R.id.about_back);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchActivity();
            }
        });
    }

    private void launchActivity() {

        Intent intent = new Intent(this, Activity_HomeScreen.class);
        startActivity(intent);
    }
}
