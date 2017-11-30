package jeffreysabocsc415.csc415_sabo_individualproject;

public class Edge {

    //edge variables
    private int weight;
    private Vertex v1, v2;

    //edge methods
    public int get_weight()
    {
       return this.weight;
    }

    public void set_weight(int weight)
    {
        return;
    }

    public Vertex get_connection(String startnode)
    {
        if (v1.get_name().equals(startnode)){
            return v2;
        }
        else {
            return v1;
        }
    }

    private void set_connections(int weight)
    {
        return;
    }
}
