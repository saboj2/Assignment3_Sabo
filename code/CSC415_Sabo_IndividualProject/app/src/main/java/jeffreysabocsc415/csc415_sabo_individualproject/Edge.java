// Name: Jeffrey Sabo
// Course: CSC 415
// Semester: Fall 2017
// Instructor: Dr. Pulimood
// Project name: Individual Project
// Description: Gender-Neutral Bathroom Locator for TCNJ
// Filename: Edge.java
// Description: This class stores data and methods for edge objects
// Last modified on: 12/1/2017
package jeffreysabocsc415.csc415_sabo_individualproject;

import org.json.JSONException;
import org.json.JSONObject;

public class Edge {

    //edge variables
    private int weight;
    private String v1;// v2;

    //Constructor for regular values
    public Edge (int weight, String v1)// String v2)
    {
        this.weight = weight;
        this.v1 = v1;
        //this.v2 = v2;
    }
    //Constructor for JSON objects
    public Edge (JSONObject json) throws JSONException
    {
        this.weight = json.getInt("weight");
        this.v1 = json.getString("v1");
    }
    //edge methods

    //getters and setters
    public int get_weight()
    {
       return this.weight;
    }

    public void set_weight(int weight)
    {
        return;
    }

    public String get_connection()
    {
            return v1;
    }

    private void set_connections(int weight)
    {
        return;
    }
}
