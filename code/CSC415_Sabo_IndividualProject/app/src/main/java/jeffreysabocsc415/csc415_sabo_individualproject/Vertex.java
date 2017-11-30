package jeffreysabocsc415.csc415_sabo_individualproject;


import java.util.ArrayList;

public class Vertex {

    //Vertex variables
    private String name;
    private boolean is_bathroom;
    private boolean known;
    private Vertex path;
    private int dist;
    private ArrayList<Edge> neighbors;


    //Vertex methods
    public Vertex ()
    {

    }
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
