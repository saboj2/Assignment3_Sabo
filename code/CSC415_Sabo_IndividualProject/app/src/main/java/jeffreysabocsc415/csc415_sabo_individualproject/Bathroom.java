// Name: Jeffrey Sabo
// Course: CSC 415
// Semester: Fall 2017
// Instructor: Dr. Pulimood
// Project name: Individual Project
// Description: Gender-Neutral Bathroom Locator for TCNJ
// Filename: Bathroom.java
// Description: This class stores data and methods for bathroom objects
// Last modified on: 12/1/2017
package jeffreysabocsc415.csc415_sabo_individualproject;

import org.json.JSONException;
import org.json.JSONObject;

public class Bathroom {

    //Bathroom variables
    private boolean is_residential;
    private String floor;
    private Review ratings[];

    //Constructor for regular values
    public Bathroom (boolean is_residential, String floor)
    {
        this.is_residential = is_residential;
        this.floor = floor;
    }
    //Constructor for JSON objects
    public Bathroom (JSONObject json) throws JSONException
    {
        this.is_residential = json.getBoolean("is_residential");
        this.floor = json.getString("floor");
    }
    //Bathroom methods

    //getters and setters
    public String get_floor()
    {
        return this.floor;
    }

    public void set_floor(String floor)
    {
        this.floor = floor;
        return;
    }

    public boolean get_is_residential()
    {
        return this.is_residential;
    }

    public void set_is_residential(boolean is_residential)
    {
        this.is_residential = is_residential;
        return;
    }

    //reviews not implemented yet
    public void leave_review()
    {

    }

    public Review[] get_ratings()
    {
        return this.ratings;
    }

    public void set_ratings(Review name)
    {
        return;
    }
}
