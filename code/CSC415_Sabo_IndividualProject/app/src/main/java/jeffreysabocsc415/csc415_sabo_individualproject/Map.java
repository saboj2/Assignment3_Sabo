// Name: Jeffrey Sabo
// Course: CSC 415
// Semester: Fall 2017
// Instructor: Dr. Pulimood
// Project name: Individual Project
// Description: Gender-Neutral Bathroom Locator for TCNJ
// Filename: Map.java
// Description: This class stores data and methods for map objects
// Last modified on: 12/1/2017
package jeffreysabocsc415.csc415_sabo_individualproject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.UUID;

public class Map {

    private String school_name;
    private ArrayList<Vertex> vertices;

    private static final String JSON_NAME = "school_name";
    private static final String JSON_VERTICES = "vertices";

    //Constructor for regular values
    public Map(String school_name, ArrayList<Vertex> vertices) {
        this.school_name = school_name;
        this.vertices = vertices;
    }

    //Constructor for JSON values
    public Map(JSONObject json) throws JSONException {
        this.school_name = json.getString("school_name");
        JSONArray json_vertices = json.getJSONArray("vertices");
        this.vertices = new ArrayList<>();
        for (int i = 0; i < json_vertices.length(); ++i) {
            Vertex temp = new Vertex(json_vertices.getJSONObject(i));
            this.vertices.add(temp);
        }
    }

    //-----------------------------------------------------------------------------------------
//
//  Function: closest_bathroom()
//
//    Parameters:
//    input String start_location
//
//
//    Pre-condition: the user picked a starting location and chose to search for nearby bathrooms
//    Post-condition: determines distance of every vertex from the starting location, and returns the
    // closest residential and nonresidential gender neutral bathrooms
//-----------------------------------------------------------------------------------------
    public Vertex closest_bathroom(String start_location) {
        //Dijkstra's algorithm

        //get vertex from vertex name
        Vertex start_vertex = find_vertex(start_location);

        //if the starting location is a gn bathroom, return it
        if (start_vertex.get_isbathroom()) {
            return start_vertex;
        }


        LinkedList<Vertex> known_vertices = new LinkedList<Vertex>();
        LinkedList<Vertex> unknown_vertices = new LinkedList<Vertex>();
        LinkedList<Vertex> res_bathrooms = new LinkedList<Vertex>();
        LinkedList<Vertex> nonres_bathrooms = new LinkedList<Vertex>();

        //initialize all vertices in graph, group bathrooms into lists for later
        for (int j = 0; j < vertices.size(); ++j) {
            vertices.get(j).set_dist(Integer.MAX_VALUE);
            vertices.get(j).set_known(false);
            if (vertices.get(j).get_isbathroom() && vertices.get(j).get_bathroom().get_is_residential()) {
                res_bathrooms.add(vertices.get(j));
            } else if (vertices.get(j).get_isbathroom() && !vertices.get(j).get_bathroom().get_is_residential()) {
                nonres_bathrooms.add(vertices.get(j));
            }
        }

        start_vertex.set_dist(0);
        unknown_vertices.add(start_vertex);

        //cycle through all unknown vertices
        while (unknown_vertices.size() != 0) {

            //current vertex is removed from unknown
            Vertex current_vertex = unknown_vertices.removeFirst();

            //cycle through all neighbors of current vertex
            for (int i = 0; i < current_vertex.get_neighbors().size(); ++i) {

                //if the vertex we are looking at is not known
                Vertex examined_vertex = find_vertex(current_vertex.get_neighbors().get(i).get_connection());
                if (!known_vertices.contains(examined_vertex)) {

                    //if the distance to that vertex is shorter than the currently known shortest distance
                    if ((current_vertex.get_dist() + current_vertex.get_neighbors().get(i).get_weight()) < (examined_vertex.get_dist())) {

                        //set new shortest distance
                        examined_vertex.set_dist((current_vertex.get_dist() + current_vertex.get_neighbors().get(i).get_weight()));

                        //route back to the current node
                        examined_vertex.set_path(current_vertex);
                    }

                    //add connected vertex to the unknown_vertices
                    if (!unknown_vertices.contains(examined_vertex)) {

                        unknown_vertices.add(examined_vertex);
                    }
                }
            }
            //move vertex to known vertices
            known_vertices.add(current_vertex);
        }

        int distance = 0;
        Vertex closest_res_bathroom = new Vertex();
        Vertex closest_nonres_bathroom = new Vertex();
        //Find non-residential bathroom with shortest path
        for (int k = 0; k < res_bathrooms.size(); ++k) {
            if (res_bathrooms.get(k).get_dist() < distance) {
                closest_res_bathroom = res_bathrooms.get(k);
            }
        }
        distance = 0;
        //Find residential bathroom with shortest path
        for (int k = 0; k < nonres_bathrooms.size(); ++k) {
            if (nonres_bathrooms.get(k).get_dist() < distance) {
                closest_nonres_bathroom = nonres_bathrooms.get(k);
            }
        }
        return closest_res_bathroom;

    }

    //-----------------------------------------------------------------------------------------
//
//  Function: find_vertex()
//
//    Parameters:
//    input String vertex_name
//
//
//    Pre-condition: only the name of a vertex is known, and the user/program wants the vertex itself
//    Post-condition: returns the vertex that has the name that is known
//-----------------------------------------------------------------------------------------
    public Vertex find_vertex(String vertex_name) {
        for (int i = 0; i < this.vertices.size(); ++i) {
            Vertex temp = vertices.get(i);
            if (temp.get_name().equals(vertex_name)) {
                return temp;
            }
        }
        return null;
    }


    //getters and setters
    private String get_school_name() {
        return this.school_name;
    }

    private void set_school_name(String name) {
        return;
    }

    public ArrayList<Vertex> get_vertices() {
        return this.vertices;
    }
}
