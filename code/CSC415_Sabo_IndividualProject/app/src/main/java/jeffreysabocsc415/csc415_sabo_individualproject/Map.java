package jeffreysabocsc415.csc415_sabo_individualproject;


import java.util.ArrayList;

public class Map {

    //Map variables
    private String start_location;
    private String end_location;
    private String school_name;
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> path;

    //Map methods
    private void closest_bathroom(String start_location)
    {
        //Dijkstra's algorithm

        //find the current vertex
        Vertex current_vertex = new Vertex();
        for(int i=0; i<this.vertices.size();++i)
        {
            Vertex temp = vertices.get(i);
            if(temp.get_name().equals(start_location))
            {
                current_vertex = temp;
                break;
            }
        }

        int closest_vertex;
        for(int i=0; i<current_vertex.get_neighbors().size(); ++i)
        {
            if( !current_vertex.get_neighbors().get(i).get_connection(current_vertex.get_name()).get_known()) {
                if ((current_vertex.get_dist() + current_vertex.get_neighbors().get(i).get_weight()) < (current_vertex.get_neighbors().get(i).get_connection(current_vertex.get_name()).get_dist())) {

                    current_vertex.get_neighbors().get(i).get_connection(current_vertex.get_name()).set_path(current_vertex);
                }
            }
        }

        /*
        current_vertex.set_known(true);
        current_vertex.set_dist(0);

        for(int i=0; i<current_vertex.get_neighbors().size(); ++i)
        {
            if( !current_vertex.get_neighbors().get(i).get_connection(current_vertex.get_name()).get_known()) {
                if ((current_vertex.get_dist() + current_vertex.get_neighbors().get(i).get_weight()) < (current_vertex.get_neighbors().get(i).get_connection(current_vertex.get_name()).get_dist())) {
                    current_vertex.get_neighbors().get(i).get_connection(current_vertex.get_name()).set_dist(current_vertex.get_dist() + current_vertex.get_neighbors().get(i).get_weight());
                    current_vertex.get_neighbors().get(i).get_connection(current_vertex.get_name()).set_path(current_vertex);
                }
            }
        }
        */

        return;
    }

    private String get_start_location()
    {
        return this.start_location;
    }

    private void set_start_location(String name)
    {
        return;
    }

    private String get_end_location()
    {
        return this.end_location;
    }

    private void set_end_location(String name)
    {
        return;
    }

    private String get_school_name()
    {
        return this.school_name;
    }

    private void set_school_name(String name)
    {
        return;
    }

    private ArrayList<Edge> get_path()
    {
        return this.path;
    }

    private void set_path(Edge name)
    {
        return;
    }
}
