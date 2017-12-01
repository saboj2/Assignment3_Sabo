// Name: Jeffrey Sabo
// Course: CSC 415
// Semester: Fall 2017
// Instructor: Dr. Pulimood
// Project name: Individual Project
// Description: Gender-Neutral Bathroom Locator for TCNJ
// Filename: Vertex.java
// Description: This class stores data and methods for vertex objects
// Last modified on: 12/1/2017
package jeffreysabocsc415.csc415_sabo_individualproject;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Vertex {

    //Vertex variables
    private String name;
    private boolean is_bathroom;
    private Bathroom bathroom;
    private boolean known;
    private Vertex path;
    private int dist = 0;
    private ArrayList<Edge> neighbors;


    //Vertex methods
    //Constructor for regular values
    public Vertex (String name, boolean is_bathroom, Bathroom bathroom, ArrayList<Edge> neighbors)
    {
        this.name = name;
        this.is_bathroom = is_bathroom;
        this.bathroom = bathroom;
        this.neighbors = neighbors;
    }
    //Constructor for JSON objects
    public Vertex (JSONObject json) throws JSONException
    {
        this.name = json.getString("name");
        this.is_bathroom = json.getBoolean("is_bathroom");
        if(json.has("bathroom")) {
            this.bathroom = new Bathroom(json.getJSONObject("bathroom"));
        }
        JSONArray json_neighbors = json.getJSONArray("neighbors");
        this. neighbors = new ArrayList<>();
        for(int i=0; i<json_neighbors.length(); ++i) {
            Edge temp = new Edge (json_neighbors.getJSONObject(i));
            this.neighbors.add(temp);
        }
    }

    //General constructor for empty vertices
    public Vertex ()
    {

    }

    //getters and setters
    public String get_name()
    {
        return this.name;
    }

    public void set_name(String name)
    {
        return;
    }

    public boolean get_isbathroom()
    {
        return this.is_bathroom;
    }

    public void set_isbathroom(boolean isbathroom)
    {
        return;
    }

    public Bathroom get_bathroom()
    {
        return this.bathroom;
    }

    public ArrayList<Edge> get_neighbors()
    {
        return new ArrayList<Edge>(this.neighbors);
    }

    public void set_neighbors(Vertex neighbor1, Vertex neighbor2)
    {
        return;
    }

    public boolean get_known()
    {
        return this.known;
    }

    public void set_known(boolean known)
    {
        this.known = known;
    }

    public int get_dist()
    {
        return this.dist;
    }

    public void set_dist(int dist)
    {
        this.dist = dist;
    }

    public Vertex get_path()
    {
        return this.path;
    }

    public void set_path(Vertex path)
    {
        this.path = path;
    }
}
